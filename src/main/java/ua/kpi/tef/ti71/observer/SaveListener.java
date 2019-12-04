package ua.kpi.tef.ti71.observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveListener implements EventListener {

    public SaveListener() {
        // It's empty
    }

    @Override
    public void update(String eventType) {
        Logger logger  = LogManager.getLogger();

        logger.info("Saved");
    }
}
