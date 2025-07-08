import java.util.Map;

public class QuantumBookstoreFullTest
{
    public static void main(String[] args)
    {
        // Create services
        IShippingService shippingService = new ShippingService();
        IMailService mailService = new MailService();

        // Create inventory and bookstore
        Inventory inventory = new Inventory();
        Bookstore store = new Bookstore(inventory);

        // Add books
        PaperBook paper = new PaperBook("ISBN-01", "Java", "Ahmed Ali", 2010, 45.00, 10, shippingService);
        EBook ebook = new EBook("ISBN-02", "Clean Code", "Omar Hatem", 2016, 30.00, ".pdf", mailService);
        ShowcaseBook showcase = new ShowcaseBook("ISBN-03", "Design Patterns", "Ziad Faiz", 2000);
        ShowcaseBook showcase2 = new ShowcaseBook("ISBN-04", "OOP", "Martin Fowler", 2015);

        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(showcase);
        inventory.addBook(showcase2);


        // Case 1: Buy a PaperBook
        System.out.println("\nCase 1: Buy a PaperBook");
        try
        {
            store.buyBook("ISBN-01", 2, "user@gmail.com", "Ahmed Orabi St");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // Case 2: Buy an EBook
        System.out.println("\nCase 2: Buy an EBook");
        try
        {
            store.buyBook("ISBN-02", 1, "user@gmail.com", "");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // Case 3: Buy another ShowcaseBook in inventory
        System.out.println("\nCase 3: Buy ShowcaseBook exite in inventory");
        try
        {
            store.buyBook("ISBN-04", 1, "user@gmail.com", "");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // Case 4: Remove outdated books (> 20 years old)
        System.out.println("\nCase 4: Remove outdated books");
        int currentYear = 2025;
        Map<String, Book> removed = inventory.removeOutdatedBooks(20, currentYear);
        if (removed.isEmpty())
        {
            System.out.println("No outdated books removed.");
        }
        else
        {
            for (Book b : removed.values())
            {
                System.out.println("Removed: " + b.getTitle());
            }
        }

        // Case 5: Try buying book not in inventory
        System.out.println("\nCase 5: Buy a Book not exite in inventory");
        try
        {
            store.buyBook("ISBN-03", 1, "user@gmail.com", "");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
