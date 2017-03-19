package com.takemeout.event.registrationservice;

import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;
import java.util.List;

public interface IEventRegistrationDAO {
  List<EventOverviewProjection> getRegisteredEvents(int userId);
  void registerEvent(RegisterEventRequest req, int userId);
  void registerLocation(RegisterLocationRequest req, int userId);
  void registerPerformer(RegisterPerformerRequest req, int userId);
}
