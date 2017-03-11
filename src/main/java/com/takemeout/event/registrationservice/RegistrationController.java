package com.takemeout.event.registrationservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.JwtException;
import java.util.List;
import java.io.IOException;

import com.takemeout.jwt.JwtUtil;
import com.takemeout.event.projections.EventOverviewProjection;
import com.takemeout.event.registration.requests.*;

@RestController
public class RegistrationController {

  IEventDAO eventDao = EventRegistrationDAO.getIEventDao();

  @CrossOrigin
  @RequestMapping(value = "/event/registration", method = RequestMethod.GET)
  public List<EventOverviewProjection> getRegisteredEvents(@RequestHeader(value="token") String token,
                                                           HttpServletResponse res) {
    try {
      return eventDao.getRegisteredEvents(JwtUtil.parseToken(token).getId());
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(res.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerEvent(@RequestHeader(value="token") String token,
                            @RequestBody RegisterEventRequest req,
                            HttpServletResponse res) {
    try {
      eventDao.registerEvent(req, JwtUtil.parseToken(token).getId());
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(res.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration/location", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerLocation(@RequestHeader(value="token") String token,
                                @RequestBody RegisterLocationRequest req,
                                HttpServletResponse res) {
    try {
      eventDao.registerLocation(req, JwtUtil.parseToken(token).getId());
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(res.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerPerformer(@RequestHeader(value="token") String token,
                               @RequestBody RegisterPerformerRequest req,
                               HttpServletResponse res) {
    try {
      eventDao.registerLocation(req, JwtUtil.parseToken(token).getId());
    } catch(JwtException e) {
      System.out.println("Access token is invalid\n"+e.getMessage());
      res.setStatus(res.SC_UNAUTHORIZED, "Access token is invalid\n"+e.getMessage());
    }
  }
}
