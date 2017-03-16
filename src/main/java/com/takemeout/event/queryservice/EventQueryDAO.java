package com.takemeout.event.queryservice;

import org.springframework.stereotype.Component;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import com.takemeout.common.BaseDAO;
import com.takemeout.util.SessionUtil;
import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;
import java.util.List;

@Component("EventQueryDAO")
public class EventQueryDAO extends BaseDAO implements IEventQueryDAO {

  public EventDetailProjection getEventDetails(int eventId) {
    return executeR((session) -> {
      return session.get(EventDetailProjection.class, eventId);
    });
  }

  public List<EventOverviewProjection> getEvents() {
    return executeR((session) -> {
      return session.createQuery("from EventOverviewProjection" //where time >= current_date
                                ,EventOverviewProjection.class)
                    .getResultList();
    });
  }

  public List<LocationProjection> getLocations() {
    return executeR((session) -> {
      return session.createQuery("FROM LocationProjection", LocationProjection.class)
                    .getResultList();
    });
  }

  public List<PerformerProjection> getPerformers() {
    return executeR((session) -> {
      return session.createQuery("FROM PerformerProjection", PerformerProjection.class)
                    .getResultList();
    });
  }

  public List<TypeItem> getTypes() {
    return executeR((session) -> {
      return session.createQuery("FROM TypeItem", TypeItem.class)
                    .getResultList();
    });
  }
}
