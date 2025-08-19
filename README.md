# Book Database Application

This application is a simple Java-based program that allows users to interact with a book database. It provides functionalities such as counting books by an author, listing all authors, filtering books by rating, and more.

## Components

### 1. `Book.java`
- Represents the `Book` class, which models the attributes of a book.
- Attributes include:
  - `title`: The title of the book.
  - `author`: The author of the book.
  - `userRating`: The user rating of the book.
  - `reviews`: The number of reviews for the book.
  - `price`: The price of the book.
  - `year`: The year the book was published.
  - `genre`: The genre of the book.
- Includes methods to get book details and print them.

### 2. `DatasetReader.java`
- Handles reading the book data from a CSV file (`data.csv`).
- Key methods:
  - `loadBooks(String filePath)`: Reads the CSV file and returns a list of `Book` objects.
  - `splitCSVLine(String line)`: Splits a CSV line into fields, handling quoted values.

### 3. `Driver.java`
- The main entry point of the application.
- Provides a menu-driven interface for users to interact with the book database.
- Features include:
  - Counting books by an author.
  - Listing all authors.
  - Displaying books by an author.
  - Filtering books by rating.
  - Calculating the total price of books by an author.
  - Displaying all books in the database.

### 4. `data.csv`
- The dataset file containing book information in CSV format.
- Columns include:
  - `Name`, `Author`, `User Rating`, `Reviews`, `Price`, `Year`, `Genre`.

## How to Run

1. **Prerequisites**:
   - Ensure you have Java installed on your system.
   - Place all the files (`Book.java`, `DatasetReader.java`, `Driver.java`, and `data.csv`) in the same directory.

2. **Compile the Code**:
   Open a terminal or command prompt, navigate to the directory containing the files, and run:
   ```sh
   javac *.java
