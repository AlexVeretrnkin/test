package ua.kpi.tef.ti71.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WindowsButton implements Button {
    public void paint() {
        Logger logger = LogManager.getLogger();

        logger.info("You have created WindowsButton.");
    }
}
