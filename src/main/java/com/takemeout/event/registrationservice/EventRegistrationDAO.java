package com.takemeout.event.registrationservice;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.MultiIdentifierLoadAccess;
import org.springframework.stereotype.Component;
import java.util.List;
import java.io.File;
import java.io.IOException;
import com.takemeout.util.SessionUtil;
import com.takemeout.common.TypeItem;
import com.takemeout.common.BaseDAO;
import com.takemeout.user.entities.User;
import com.takemeout.event.entities.Event;
import com.takemeout.event.entities.Location;
import com.takemeout.event.entities.Performer;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;

@Component("EventRegistrationDAO")
public class EventRegistrationDAO extends BaseDAO implements IEventRegistrationDAO {

  @Override
  public boolean isInit() {
    return hasEventTable();
  }

  private boolean hasEventTable() {
    List<Event> events = inTransactionR((session) -> {
      return session.createQuery("from Event e", Event.class).setMaxResults(1).list();
    });
    return !events.isEmpty();
  }

  @Override
  public List<EventOverviewProjection> getRegisteredEvents(int userId) {
    return inTransactionR((session) -> {
      return session.createQuery("from EventOverviewProjection", EventOverviewProjection.class).list();
    }
  }

  @Override
  public void registerEvent(RegisterEventRequest req, int userId) {
    inTransaction((session) -> {
      User user = session.get(User.class, userId);
      TypeItem type = session.get(TypeItem.class, req.getTypeId());
      Location location = session.get(Location.class, req.getLocationId());
      MultiIdentifierLoadAccess<Performer> mla = session.byMultipleIds(Performer.class);
      List<Performer> performers = mla.multiLoad(req.getPerformerIds());

      Event newEvent = new Event( req.getName(), req.getDescriptionEng(), req.getDescriptionIce()
                                , req.getTime(), user, type, location, performers);
      session.save(newEvent);
    });
  }

  @Override
  public void registerLocation(RegisterLocationRequest req, int userId) {
    inTransaction((session) -> {
      User user = session.get(User.class, userId);
      Location newLocation = new Location(req.getName(), req.getAddress(), req.getAccess(), user);
      session.save(newLocation);
    });
  }

  @Override
  public void registerPerformer(RegisterPerformerRequest req, int userId) {
    inTransaction((session) -> {
      User user = session.get(User.class, userId);
      Performer newPerformer = new Performer( req.getName(), req.getDescriptionEng()
                                            , req.getDescriptionIce(), user);
      session.save(newPerformer);
    });
  }
}
