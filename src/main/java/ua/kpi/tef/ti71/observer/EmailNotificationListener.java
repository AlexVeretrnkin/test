package ua.kpi.tef.ti71.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailNotificationListener implements EventListener {

    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    public void update(String eventType) {
        Logger logger = LogManager.getLogger();

        logger.info("Email to {}", email);
        logger.info("Someone has performed {}", eventType);
    }
}
