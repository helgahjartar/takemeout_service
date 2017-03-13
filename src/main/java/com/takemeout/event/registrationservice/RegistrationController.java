package com.takemeout.event.registrationservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.JwtException;
import java.util.List;
import java.io.IOException;

import com.takemeout.jwt.JwtUtil;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registrationservice.requests.*;

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
  public List<EventOverviewProjection> getRegisteredEvents(@RequestHeader(value="token") String token,
                                                           HttpServletResponse res) {
    try {
      return eventRegHandler.getRegisteredEvents(jwtHandler.parseToken(token));
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
      return null;
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/event", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerEvent(@RequestHeader(value="token") String token,
                            @RequestBody RegisterEventRequest req,
                            HttpServletResponse res) {
    try {
      eventRegHandler.registerEvent(req, jwtHandler.parseToken(token));
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/location", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerLocation(@RequestHeader(value="token") String token,
                               @RequestBody RegisterLocationRequest req,
                               HttpServletResponse res) {
    try {
      eventRegHandler.registerLocation(req, jwtHandler.parseToken(token));
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/performer", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerPerformer(@RequestHeader(value="token") String token,
                                @RequestBody RegisterPerformerRequest req,
                                HttpServletResponse res) {
    try {
      eventRegHandler.registerPerformer(req, jwtHandler.parseToken(token));
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }
}
