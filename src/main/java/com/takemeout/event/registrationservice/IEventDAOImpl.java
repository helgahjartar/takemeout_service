package com.takemeout.event.registrationservice;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.MultiIdentifierLoadAccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.takemeout.event.registrationservice.IEventDAO;
import com.takemeout.util.SessionUtil;
import com.takemeout.common.TypeItem;
import com.takemeout.user.entities.User;
import com.takemeout.event.entities.Event;
import com.takemeout.event.entities.Location;
import com.takemeout.event.entities.Performer;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registration.requests.RegisterEventRequest;

public class IEventDAOImpl implements IEventDAO {

  public static IEventDAO getIEventDao() {
    return new IEventDAOImpl();
  }

  @Override
  public boolean isInit() {
    return hasEventTable();
  }

  private boolean hasEventTable() {
    Session session =  SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<Event> events = session.createQuery("from Event e").setMaxResults(1).list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return !events.isEmpty();
  }

  @Override
  public List<EventOverviewProjection> getRegisteredEvents() {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<EventOverviewProjection> events = null;
    Query query = session.createQuery("from Event");
    events = query.list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return events;
  }

  @Override
  public void registerEvent(RegisterEventRequest req, int userId) {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User user = (User)session.get(User.class, userId);
    TypeItem type = (TypeItem)session.get(TypeItem.class, req.getTypeId());
    Location location = (Location)session.get(Location.class, req.getLocationId());
    MultiIdentifierLoadAccess<Performer> mla = session.byMultipleIds(Performer.class);
    List<Performer> performers = mla.multiLoad(req.getPerformerIds());

    Event newEvent = new Event( req.getName(), req.getDescriptionEng(), req.getDescriptionIce()
                              , req.getTime(), user, type, location, performers);

    session.save(newEvent);

    session.flush();
    session.getTransaction().commit();
    session.close();
  }
}
