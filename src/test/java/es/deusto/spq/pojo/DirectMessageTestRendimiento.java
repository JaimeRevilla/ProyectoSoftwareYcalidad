package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.client.PerformanceTest;
import es.deusto.spq.server.JUnitPerfTest;
import es.deusto.spq.server.JUnitPerfTestRequirement;

@PerformanceTest
public class DirectMessageTestRendimiento {

    DirectMessage directMessage;

    @Mock
    UserData userData;

    @Mock
    MessageData messageData;

    @Before
    public void setUp() {
        directMessage = new DirectMessage();
        directMessage.setUserData(userData);
        directMessage.setMessageData(messageData);
    }

    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void getUserData() {
        assertEquals(userData, directMessage.getUserData());
    }

    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void getMessageData() {
        assertEquals(messageData, directMessage.getMessageData());
    }
}
