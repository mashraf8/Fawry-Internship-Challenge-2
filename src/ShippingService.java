public class ShippingService implements IShippingService
{
    @Override
    public void ship(String title, String isbn, int quantity, String address)
    {
        System.out.println("Quantum book store: Shipped " + quantity + " copies of " + title + " (ISBN: " + isbn + ") to address: " + address);
    }
}
