package com.takemeout.event.registrationservice;

import org.hibernate.Query;
import org.hibernate.Session;

import com.takemeout.event.entities.Event;
import com.takemeout.event.registrationservice.IEventDAO;
import com.takemeout.util.SessionUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.takemeout.event.projections.EventProjection;
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
  public List<Event> getRegisteredEvents() {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<Event> events = null;
    Query query = session.createQuery("from Event");
    events = query.list();
    session.flush();
    session.getTransaction().commit();
    session.close();
    return events;
  }

  @Override
  public void registerEvent(RegisterEventRequest event, int userId) {
    Session session = SessionUtil.getSessionFactory().openSession();
    session.beginTransaction();

    List<Event> events = getRegisteredEvents();


    Event newEvent = new Event(userId, event.getName(), event.getTime(), event.getClock(), event.getType(), event.getDescription(), event.getAccess(), event.getLocation());

    session.save(newEvent);

    session.flush();
    session.getTransaction().commit();
    session.close();
  }
}
