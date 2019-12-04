package ua.kpi.tef.ti71.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDataSource implements DataSource {
    private String name;

    private static Logger logger = LogManager.getLogger();

    public FileDataSource(String name) {
        this.name = name;
    }

    public void writeData(String data) {
        try (FileWriter fw = new FileWriter(name)) {
            fw.write(data);
        } catch (IOException ex) {
            logger.error(ex);
        }
    }

    public String readData() {
        String result = "";

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Path pathToString = Paths.get(classLoader.getResource(name).getFile());

        try (Stream<String> st = Files.lines(pathToString)) {
            result = st.collect(Collectors.joining());
        } catch (IOException ex) {
            logger.error(ex);
        }
        return result;
    }
}
