package com.takemeout.event.queryservice;

import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;
import java.util.List;

public interface IEventQueryDAO {
  EventDetailProjection getEventDetails(int eventId);
  List<EventOverviewProjection> getEvents();
  List<LocationProjection> getLocations();
  List<PerformerProjection> getPerformers();
  List<TypeItem> getTypes();
}
