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

import com.takemeout.event.registrationservice.IEventDAO;
import com.takemeout.event.entities.Event;
import com.takemeout.jwt.JwtUtil;
import com.takemeout.event.projections.EventProjection;
import com.takemeout.event.registration.requests.RegisterEventRequest;

@RestController
public class RegistrationController {

  IEventDAO eventDao = IEventDAOImpl.getIEventDao();

  @CrossOrigin
  @RequestMapping(value = "/event/registration", method = RequestMethod.GET)
  public List<Event> getRegisteredEvents() {
    try {
      return eventDao.getRegisteredEvents();
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @CrossOrigin
  @RequestMapping(value = "/event/registration", method = RequestMethod.POST,  consumes = {"application/json;charset=UTF-8"})
  public void registerEvent(@RequestHeader(value="token") String token,
                            @RequestBody RegisterEventRequest event,
                            HttpServletResponse res) {
    try {
      eventDao.registerEvent(event, JwtUtil.parseToken(token).getId());
    } catch(JwtException e) {
      System.out.println(e.getMessage());
      res.setStatus(res.SC_UNAUTHORIZED, "Access token is invalid");
    }
  }
}
