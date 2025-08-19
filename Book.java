public class Book {
    private String title;
    private String author;
    private double userRating;
    private int reviews;
    private int price;
    private int year;
    private String genre;

    public Book(String title, String author, double userRating, int reviews, int price, int year, String genre) {
        this.title = title;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getUserRating() { return userRating; }
    public int getReviews() { return reviews; }
    public int getPrice() { return price; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    public void printDetails() {
        System.out.println("Title: " + title +
                "\nAuthor: " + author +
                "\nRating: " + userRating +
                "\nReviews: " + reviews +
                "\nPrice: $" + price +
                "\nYear: " + year +
                "\nGenre: " + genre + "\n");
    }
}