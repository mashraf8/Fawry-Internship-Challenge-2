public class ShowcaseBook extends Book
{
    public ShowcaseBook(String isbn, String title, String author, int yearPublished)
    {
        super(isbn, title, author, yearPublished, 0.0);
    }

    @Override
    public void processSale(int quantity, String email, String address)
    {
        throw new IllegalStateException("Quantum book store Error: Showcase books are not for sale.");
    }
}
