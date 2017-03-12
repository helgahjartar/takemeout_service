package com.takemeout.event.queryservice;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.MultiIdentifierLoadAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;
import java.io.IOException;
import com.takemeout.util.SessionUtil;
import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;

public class EventQueryDAO implements IEventQueryDAO {

  public static IEventQueryDAO getIEventQueryDAO() {
    return new EventQueryDAO();
  }

  @Override
  public boolean isInit() {
    return hasEventOverviewProjection();
  }

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
