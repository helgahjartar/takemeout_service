import org.junit.Test;

import com.takemeout.event.registrationservice.EventRegistrationDAO;
import com.takemeout.event.registrationservice.IEventRegistrationDAO;
import com.takemeout.event.queryservice.IEventQueryDAO;
import com.takemeout.event.queryservice.EventQueryDAO;
import com.takemeout.event.registrationservice.requests.*;
import com.takemeout.util.SessionUtil;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class InsertData {

  @Test
  public void testQueries() {
    IEventQueryDAO handler = new EventQueryDAO();
    //assertFalse(handler.getEvents().isEmpty());
    assertFalse(handler.getLocations().isEmpty());
    assertFalse(handler.getPerformers().isEmpty());
    assertFalse(handler.getTypes().isEmpty());
    assertFalse(handler.getEvents().isEmpty());
  }
}
