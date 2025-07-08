public class EBook extends Book
{
    private final String fileType;
    private final IMailService mailService;

    public EBook(String isbn, String title, String author, int yearPublished, double price, String fileType, IMailService mailService)
    {
        super(isbn, title, author, yearPublished, price);
        this.fileType = fileType;
        this.mailService = mailService;
    }

    @Override
    public void processSale(int quantity, String email, String address)
    {
        mailService.send(getTitle(), getIsbn(), fileType, email);
    }
}
