package ua.procamp.fileStats;

import ua.procamp.fileReader.FileReaders;
import ua.procamp.util.MutableInt;

import java.io.IOError;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {
    private Map<Character, MutableInt> characterOccurrences;
    private String fileContent;

    private FileStats(String fileName) {

        try {
            fileContent = FileReaders.readWholeFile(fileName).replaceAll("\\s+", "");
        } catch (IOError | NullPointerException e) {
            throw new FileStatsException("File was not found", e);
        }

//        String contents;
//        try {
//            contents = FileReaders.readWholeFile(fileName);
//        } catch (IOError | NullPointerException e) {
//            throw new FileStatsException("File was not found", e);
//        }
//        characterOccurrences = new HashMap<>();
//        for (char character : contents.toCharArray()) {
//            if (characterOccurrences.containsKey(character)) {
//                characterOccurrences.get(character).increment();
//            } else if (character != ' ') {
//                characterOccurrences.put(character, new MutableInt(1));
//            }
//        }
    }

    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {
        return new FileStats(fileName);
    }

    /**
     * Returns a number of occurrences of the particular character.
     *
     * @param character a specific character
     * @return a number that shows how many times this character appeared in a text file
     */
    public int getCharCount(char character) {
        return (int) fileContent
                .chars()
                .filter(ch -> ch == character)
                .count();
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {
        return fileContent
                .chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return Stream.of(fileContent)
                .anyMatch(item -> item.indexOf(character) > -1);
    }
}
