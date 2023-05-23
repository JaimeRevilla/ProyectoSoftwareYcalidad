package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;

import es.deusto.spq.client.PerformanceTest;
import es.deusto.spq.server.JUnitPerfTest;
import es.deusto.spq.server.JUnitPerfTestRequirement;

import org.mockito.MockedStatic;

import org.junit.Before;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@PerformanceTest
public class MessagesTestRendimiento {

    private static ZonedDateTime timestamp = ZonedDateTime.of(2023, 03, 23, 19, 15, 22, 0, ZoneId.of("Europe/Madrid"));
    private Message message;
    
    @Before
    public void setUp() {
        try (MockedStatic<ZonedDateTime> zonedDateTimeHelper = Mockito.mockStatic(ZonedDateTime.class)) {
            zonedDateTimeHelper.when(ZonedDateTime::now).thenReturn(timestamp);
            message = new Message("Hello world!");
        }
    }

    @Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void getUser() {
        User user = new User("somelogin", "passwd", "email");
        message.setUser(user);
        assertEquals(user, message.getUser());
    }

//    @Test
//    public void testToString() {
//        assertEquals("Message: message --> Hello world!, timestamp -->  Mon May 01 14:02:34 CEST 2023", message.toString());
//    }
}   
