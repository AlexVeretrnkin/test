package ua.procamp.file_reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    private FileReaders() { }
    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        String result;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Path pathToString = Paths.get(classLoader.getResource(fileName).getFile());

        Stream<String> lines = Stream.of("");

        try {
            lines = Files.lines(pathToString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            result = lines.collect(Collectors.joining("\n", "", ""));

            lines.close();
        }

        return result;
    }
}
