package com.takemeout.event.registrationservice;

import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registration.requests.RegisterEventRequest;


import java.util.List;

public interface IEventDAO {

  boolean isInit();

  void registerEvent(RegisterEventRequest req, int userId);
  List<EventOverviewProjection> getRegisteredEvents();
}
