package com.takemeout.event.registrationservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;
import com.takemeout.jwt.JwtUtil;
import java.util.List;

@RestController
public class RegistrationController {

  private IEventRegistrationDAO eventRegHandler;
  private JwtUtil jwtHandler;

  @Autowired
  public RegistrationController(@Qualifier("EventRegistrationDAO") IEventRegistrationDAO eventRegDAO,
                                @Qualifier("JwtUtil") JwtUtil jwtUtil) {
    eventRegHandler = eventRegDAO;
    jwtHandler = jwtUtil;
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/event", method = RequestMethod.GET)
  public List<EventOverviewProjection> getRegisteredEvents(@RequestHeader(value="token") String token) {
    return eventRegHandler.getRegisteredEvents(jwtHandler.parseToken(token));
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/event", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerEvent(@RequestHeader(value="token") String token,
                            @RequestBody RegisterEventRequest req) {
    eventRegHandler.registerEvent(req, jwtHandler.parseToken(token));
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/location", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerLocation(@RequestHeader(value="token") String token,
                               @RequestBody RegisterLocationRequest req) {
    eventRegHandler.registerLocation(req, jwtHandler.parseToken(token));
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/performer", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerPerformer(@RequestHeader(value="token") String token,
                                @RequestBody RegisterPerformerRequest req) {
    eventRegHandler.registerPerformer(req, jwtHandler.parseToken(token));
  }
}
