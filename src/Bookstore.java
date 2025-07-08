public class Bookstore
{
    private final Inventory inventory;

    public Bookstore(Inventory inventory)
    {
        this.inventory = inventory;
    }

    public double buyBook(String isbn, int quantity, String email, String address)
    {
        Book book = inventory.findByIsbn(isbn);
        book.processSale(quantity, email, address);
        double total = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchase completed. Total paid: " + total);
        return total;
    }
}
