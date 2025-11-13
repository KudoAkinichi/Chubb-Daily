import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FunctionalApproach {
    public static void main(String[] args) {
        String fileName = "sample.txt";

        try {
            long count = Files.lines(Paths.get(fileName))
                .flatMap(line -> java.util.Arrays.stream(line.split("\\W+")))
                .filter(word -> word.equalsIgnoreCase("india"))
                .count();

            System.out.println("Total occurrences of 'india': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
