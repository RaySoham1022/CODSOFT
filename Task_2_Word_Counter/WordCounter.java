import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to Write Text directly \nEnter '2' for Reading a File ");
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        String text = "";

        if (choice == 1) {                      
            System.out.println("Enter Your Text: ");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Provide the Path of the File : ");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File doesn't exist at Given Location");
                System.exit(1);
            }
        } else {
            System.out.println("It is not a valid choice.");
            System.exit(1);
        }

        int wordCount = countWords(text);
        System.out.println("Count of Words: " + wordCount);

        
        wordunique(text);
        occuringwords(text);
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

        public static void wordunique(String text) {
            String[] words = text.split("\\s+");
            Map<String, Integer> countofwords = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                countofwords.put(word, countofwords.getOrDefault(word, 0) + 1);
            }
            System.out.println("Count of Unique Words: " + countofwords.size());
        }

    public static void occuringwords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> countofwords = new HashMap<>();

        for (String word : words) {
            countofwords.put(word, countofwords.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countofwords.entrySet()) {
            System.out.print("\'" + entry.getKey() + "\' occurs " + entry.getValue() + " times, ");
        }
    }
}


