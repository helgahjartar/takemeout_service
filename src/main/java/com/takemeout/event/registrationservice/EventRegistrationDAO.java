package com.takemeout.event.registrationservice;

import org.hibernate.Session;
import org.hibernate.MultiIdentifierLoadAccess;
import org.springframework.stereotype.Component;
import java.util.List;
import com.takemeout.common.BaseDAO;
import com.takemeout.common.TypeItem;
import com.takemeout.user.entities.User;
import com.takemeout.event.entities.Event;
import com.takemeout.event.entities.Location;
import com.takemeout.event.entities.Performer;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;

@Component("EventRegistrationDAO")
public class EventRegistrationDAO extends BaseDAO implements IEventRegistrationDAO {

  public List<EventOverviewProjection> getRegisteredEvents(int userId) {
    return executeR((session) -> {
      return session.createQuery("from EventOverviewProjection userId = :userId",EventOverviewProjection.class)
                    .getResultList();
    });
  }

  public void registerEvent(RegisterEventRequest req, int userId) {
    execute((session) -> {
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

  public void registerLocation(RegisterLocationRequest req, int userId) {
    execute((session) -> {
      User user = session.get(User.class, userId);
      Location newLocation = new Location(req.getName(), req.getAddress(), req.getAccess(), user);
      session.save(newLocation);
    });
  }

  public void registerPerformer(RegisterPerformerRequest req, int userId) {
    execute((session) -> {
      User user = session.get(User.class, userId);
      Performer newPerformer = new Performer( req.getName(), req.getDescriptionEng()
                                            , req.getDescriptionIce(), user);
      session.save(newPerformer);
    });
  }
}
