package com.takemeout.event.queryservice;

import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;
import java.util.List;

public interface IEventQueryDAO {

  boolean isInit();

  EventDetailProjection getEventDetails(int eventId);
  List<EventOverviewProjection> getEvents();
  List<LocationProjection> getLocations();
  List<PerformerProjection> getPerformer();
  List<TypeItem> getTypes();
}
