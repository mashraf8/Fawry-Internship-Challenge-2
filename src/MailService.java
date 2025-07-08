public class MailService implements IMailService
{
    @Override
    public void send(String title, String isbn, String fileType, String email)
    {
        System.out.println("Quantum book store: Sent " + title + " (ISBN: " + isbn + ", " + fileType + ") to email: " + email);
    }
}
