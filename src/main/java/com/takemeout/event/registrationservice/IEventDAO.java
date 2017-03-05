package com.takemeout.event.registrationservice;

import com.takemeout.event.entities.Event;
import com.takemeout.event.registration.requests.RegisterEventRequest;


import java.util.List;

public interface IEventDAO {

  boolean isInit();

  void registerEvent(RegisterEventRequest req, int userId);
  List<Event> getRegisteredEvents();
}
