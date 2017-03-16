package com.takemeout.test.event.entities;

import org.junit.Test;
import static org.junit.Assert.*;

import com.takemeout.event.entities.Event;

public class EventTest {
        // 
        // @Test(expected=IllegalArgumentException.class)
        // public void illegalUserIdShouldThrowExceptionTest() {
        //         Event eventClass1 = new Event(-1,"asd","asd","asd","asd","asd","asd","asd");
        //         Event eventClass2 = new Event(0,"asd","asd","asd","asd","asd","asd","asd");
        // }
        //
        // @Test(expected=IllegalArgumentException.class)
        // public void emptyStringShouldThrowExceptionTest() {
        //         Event eventClass1 = new Event(12,"","asd","asd","asd","asd","asd","asd");
        //         Event eventClass2 = new Event(12,"asd","","asd","asd","asd","asd","asd");
        //         Event eventClass3 = new Event(12,"asd","asd","","asd","asd","asd","asd");
        //         Event eventClass4 = new Event(12,"asd","asd","asd","","asd","asd","asd");
        //         Event eventClass5 = new Event(12,"asd","asd","asd","asd","","asd","asd");
        //         Event eventClass6 = new Event(12,"asd","asd","asd","asd","asd","","asd");
        //         Event eventClass7 = new Event(12,"asd","asd","asd","asd","asd","asd","");
        // }
        //
        // @Test(expected=IllegalArgumentException.class)
        // public void nullValueShouldThrowExceptionTest() {
        //         Event eventClass1 = new Event(12,null,"asd","asd","asd","asd","asd","asd");
        //         Event eventClass2 = new Event(12,"asd",null,"asd","asd","","asd","asd");
        //         Event eventClass3 = new Event(12,"asd","asd",null,"asd","asd","asd","asd");
        //         Event eventClass4 = new Event(12,"asd","asd","asd",null,"asd","asd","asd");
        //         Event eventClass5 = new Event(12,"asd","asd","asd","asd",null,"asd","asd");
        //         Event eventClass6 = new Event(12,"asd","asd","asd","asd","asd",null,"asd");
        //         Event eventClass7 = new Event(12,"asd","asd","asd","asd","asd","asd",null);
        // }
        //
        // @Test
        // public void validDataShouldCreateEventTest() {
        //         Event eventClass = new Event(12,"name","time","clock","type","description","access","location");
        //
        //         assertEquals(eventClass.getUserId(), 12);
        //         assertEquals(eventClass.getName(), "name");
        //         assertEquals(eventClass.getTime(), "time");
        //         assertEquals(eventClass.getClock(), "clock");
        //         assertEquals(eventClass.getType(), "type");
        //         assertEquals(eventClass.getDescription(), "description");
        //         assertEquals(eventClass.getAccess(), "access");
        //         assertEquals(eventClass.getLocation(), "location");
        // }
}
