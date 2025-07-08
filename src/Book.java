public abstract class Book
{
    private final String isbn;
    private final String title;
    private final String author;
    private final int yearPublished;
    private final double price;

    protected Book(String isbn, String title, String author, int yearPublished, double price)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }
 
    public int getYearPublished()
    {
        return yearPublished;
    }

    public double getPrice()
    {
        return price;
    }

    public abstract void processSale(int quantity, String email, String address);
}
