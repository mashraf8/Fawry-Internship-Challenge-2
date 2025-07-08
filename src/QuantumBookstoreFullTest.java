import java.util.Map;

public class QuantumBookstoreFullTest
{
    public static void main(String[] args)
    {
        // Create services
        IShippingService shippingService = new ShippingService();
        IMailService mailService = new MailService();


        Inventory inventory = new Inventory();

        // Create Books
        PaperBook paper = new PaperBook("ISBN-01", "Java", "Ahmed Ali", 2010, 45.00, 10, shippingService);
        EBook ebook = new EBook("ISBN-02", "Clean Code", "Omar Hatem", 2016, 30.00, ".pdf", mailService);
        ShowcaseBook showcase = new ShowcaseBook("ISBN-03", "Design Patterns", "Ziad Faiz", 2000);

        // Add to Inventory
        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(showcase);

        // Remove outdated > 20 years
        int currentYear = 2025;
        Map<String, Book> removed = inventory.removeOutdatedBooks(20, currentYear);

        // Buy operations
        Bookstore store = new Bookstore(inventory);
        try
        {
            store.buyBook("ISBN-01", 2, "user@gmail.com", "Ahmed Orabi St");
            store.buyBook("ISBN-02", 1, "user@gmail.com", "");
            store.buyBook("ISBN-03", 1, "user@gmail.com", "");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
