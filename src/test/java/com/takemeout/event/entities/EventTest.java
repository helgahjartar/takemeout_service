package com.takemeout.test.event.entities;

import org.junit.Test;
import static org.junit.Assert.*;

import com.takemeout.event.entities.Event;

public class EventTest {

  @Test
  public void testQueries() {
    IEventQueryDAO handler = new EventQueryDAO();
    assertFalse(handler.getLocations().isEmpty());
    assertFalse(handler.getPerformers().isEmpty());
    assertFalse(handler.getTypes().isEmpty());
    assertFalse(handler.getEvents().isEmpty());
  }
}
