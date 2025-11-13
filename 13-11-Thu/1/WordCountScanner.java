import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCountScanner {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        int count = 0;

        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split("\\W+");

                for (String w : words) {
                    if (w.equalsIgnoreCase("india")) {
                        count++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("Total occurrences of 'india': " + count);
    }
}
