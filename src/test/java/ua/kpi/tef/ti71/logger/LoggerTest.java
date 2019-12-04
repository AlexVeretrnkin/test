package ua.kpi.tef.ti71.logger;

import static org.junit.jupiter.api.Assertions.*;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoggerTest {
    private static Logger log = null;
    private static final Marker TEST_MARKER = MarkerManager.getMarker("TEST");

    @BeforeAll
    public static void setLogger() throws MalformedURLException {
        log = LogManager.getLogger();
    }

    @Test
    public void testOne() {
        log.debug(TEST_MARKER,"Debug Message Logged !!!");
        log.info("Info Message Logged !!!");
        log.error(TEST_MARKER, "Error Message Logged !!!", new NullPointerException("NullError"));

        assertTrue(true);
    }
}

