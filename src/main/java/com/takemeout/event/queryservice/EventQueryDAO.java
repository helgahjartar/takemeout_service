package com.takemeout.event.queryservice;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.MultiIdentifierLoadAccess;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;
import java.io.IOException;
import com.takemeout.util.SessionUtil;
import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;

@Component("EventQueryDAO")
public class EventQueryDAO implements IEventQueryDAO {

  @Override
  public boolean isInit() {
    return hasEventOverviewProjection();
  }

  @SuppressWarnings("unchecked")
  private boolean hasEventOverviewProjection() {
    Session session =  SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<EventOverviewProjection> events = session.createQuery("from EventOverviewProjection e").setMaxResults(1).list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return !events.isEmpty();
  }

  public EventDetailProjection getEventDetails(int eventId) {
    Session session = SessionUtil.getSessionFactory().openSession();

    EventDetailProjection event = session.get(EventDetailProjection.class, eventId);

    session.flush();
    session.close();

    return event;
  }

  public List<EventOverviewProjection> getEvents() {
    return null;
  }

  public List<LocationProjection> getLocations() {
    return null;
  }

  public List<PerformerProjection> getPerformer() {
    return null;
  }

  public List<TypeItem> getTypes() {
    return null;
  }
}
