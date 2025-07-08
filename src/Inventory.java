import java.util.Map;
import java.util.LinkedHashMap;

public class Inventory
{
    private Map<String, Book> bookMap = new LinkedHashMap<>();

    public void addBook(Book book)
    {
        bookMap.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added " + book.getTitle() + " to inventory.");
    }

    public Map<String, Book> removeOutdatedBooks(int maxAgeYears, int currentYear)
    {
        Map<String, Book> removedMap = new LinkedHashMap<>();
        Map<String, Book> updatedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : bookMap.entrySet())
        {
            Book book = entry.getValue();
            String isbn = entry.getKey();
            int age = currentYear - book.getYearPublished();
            if (age > maxAgeYears)
            {
                removedMap.put(isbn, book);
                System.out.println("Quantum book store: Removed outdated book " + book.getTitle() + " (ISBN: " + isbn + ") published in " + book.getYearPublished() + ".");
            }
            else
            {
                updatedMap.put(isbn, book);
            }
        }

        bookMap = updatedMap;
        return removedMap;
    }

    public Book findByIsbn(String isbn)
    {
        Book book = bookMap.get(isbn);
        if (book == null)
        {
            throw new IllegalStateException("Quantum book store Error: Book ISBN not found in inventory.");
        }
        return book;
    }

}
