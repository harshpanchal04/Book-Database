import java.io.*;
import java.util.*;

public class DatasetReader {

    public static List<Book> loadBooks(String filePath) {
        List<Book> bookList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            boolean skipHeader = true;

            while ((currentLine = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] fields = splitCSVLine(currentLine);

                if (fields.length >= 7) {
                    try {
                        String title = fields[0].trim();
                        String author = fields[1].trim();
                        double rating = Double.parseDouble(fields[2].trim());
                        int reviewCount = Integer.parseInt(fields[3].trim());
                        int price = Integer.parseInt(fields[4].trim());
                        int year = Integer.parseInt(fields[5].trim());
                        String genre = fields[6].trim();

                        Book book = new Book(title, author, rating, reviewCount, price, year, genre);
                        bookList.add(book);
                    } catch (NumberFormatException ex) {
                        System.err.println("Invalid data format in line: " + currentLine);
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Failed to read file: " + ex.getMessage());
        }

        return bookList;
    }

    private static String[] splitCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder field = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (ch == '"') {
                insideQuotes = !insideQuotes;
            } else if (ch == ',' && !insideQuotes) {
                tokens.add(field.toString());
                field.setLength(0);
            } else {
                field.append(ch);
            }
        }

        tokens.add(field.toString());
        return tokens.toArray(new String[0]);
    }
}