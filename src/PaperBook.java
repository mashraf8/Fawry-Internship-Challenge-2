public class PaperBook extends Book
{
    private int stock;
    private final IShippingService shippingService;

    public PaperBook(String isbn, String title, String author, int yearPublished, double price, int initialStock, IShippingService shippingService)
    {
        super(isbn, title, author, yearPublished, price);
        this.stock = initialStock;
        this.shippingService = shippingService;
    }

    public void addStock(int quantity)
    {
        stock += quantity;
    }

    @Override
    public void processSale(int quantity, String email, String address)
    {
        if (quantity > stock)
        {
            throw new IllegalStateException("Quantum book store Error: Book not in stock or insufficient quantity.");
        }
        stock -= quantity;
        shippingService.ship(getTitle(), getIsbn(), quantity, address);
    }
}
