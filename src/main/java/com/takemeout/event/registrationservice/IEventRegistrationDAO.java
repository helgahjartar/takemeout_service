package com.takemeout.event.registrationservice;

import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;
import java.util.List;

public interface IEventRegistrationDAO {
  List<EventOverviewProjection> getRegisteredEvents(int userId);
  int registerEvent(RegisterEventRequest req, int userId);
  int registerLocation(RegisterLocationRequest req, int userId);
  int registerPerformer(RegisterPerformerRequest req, int userId);
}
