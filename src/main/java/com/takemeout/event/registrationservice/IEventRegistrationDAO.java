package com.takemeout.event.registrationservice;

import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registration.requests.*;
import java.util.List;

public interface IEventRegistrationDAO {

  boolean isInit();

  void registerEvent(RegisterEventRequest req, int userId);
  void registerLocation(RegisterLocationRequest req, int userId);
  void registerPerformer(RegisterPerformerRequest req, int userId);
  List<EventOverviewProjection> getRegisteredEvents(int userId);
}
