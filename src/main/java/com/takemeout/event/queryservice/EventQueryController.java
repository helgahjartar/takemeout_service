package com.takemeout.event.queryservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import com.takemeout.event.projections.*;
import com.takemeout.common.TypeItem;
import java.util.List;

@RestController
public class EventQueryController {

  private IEventQueryDAO eventQueryHandler;

  @Autowired
  public EventQueryController(@Qualifier("EventQueryDAO") IEventQueryDAO handler) {
    eventQueryHandler = handler;
  }

  @CrossOrigin
  @RequestMapping(value = "event/query/details", method=RequestMethod.GET)
  public EventDetailProjection getEventDetails(@RequestParam(value="eventId") int eventId) {
      return eventQueryHandler.getEventDetails(eventId);
  }

  @CrossOrigin
  @RequestMapping(value = "event/query/events", method=RequestMethod.GET)
  public List<EventOverviewProjection> getEvents() {
    return eventQueryHandler.getEvents();
  }

  @CrossOrigin
  @RequestMapping(value = "event/query/locations", method=RequestMethod.GET)
  public List<LocationProjection> getLocations() {
    return eventQueryHandler.getLocations();
  }

  @CrossOrigin
  @RequestMapping(value = "event/query/performers", method=RequestMethod.GET)
  public List<PerformerProjection> getPerformers() {
    return eventQueryHandler.getPerformers();
  }

  @CrossOrigin
  @RequestMapping(value = "event/query/types", method=RequestMethod.GET)
  public List<TypeItem> getTypes() {
    return eventQueryHandler.getTypes();
  }
}
