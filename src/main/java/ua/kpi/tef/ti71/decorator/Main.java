package ua.kpi.tef.ti71.decorator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out.txt")
                )
        );
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out.txt");

        logger.info("- Input ----------------");
        logger.info("Input {}", salaryRecords);
        logger.info("- Encoded --------------");
        String res = plain.readData();
        logger.info("Encoded {}", res);
        res = encoded.readData();
        logger.info("- Decoded --------------");
        logger.info("Decoded {}", res);
    }
}
