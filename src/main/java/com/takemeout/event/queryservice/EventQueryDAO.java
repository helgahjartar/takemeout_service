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
import com.takemeout.common.BaseDAO;
import com.takemeout.util.SessionUtil;
import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;

@Component("EventQueryDAO")
public class EventQueryDAO extends BaseDAO implements IEventQueryDAO {

  public EventDetailProjection getEventDetails(int eventId) {
    return executeR((session) -> {
      return session.get(EventDetailProjection.class, eventId);
    });
  }

  public List<EventOverviewProjection> getEvents() {
    return executeR((session) -> {
      return null;
    });
  }

  public List<LocationProjection> getLocations() {
    return executeR((session) -> {
      return null;
    });
  }

  public List<PerformerProjection> getPerformer() {
    return executeR((session) -> {
      return null;
    });
  }

  public List<TypeItem> getTypes() {
    return executeR((session) -> {
      return null;
    });
  }
}
