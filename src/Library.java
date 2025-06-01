import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Library {
    private BookManager bookManager;
    private MemberManager memberManager;
    private TransactionManager transactionManager;

    public Library() {
        this.bookManager = new BookManager();
        this.memberManager = new MemberManager();
        this.transactionManager = new TransactionManager();
    }

    public void addBook(String isbn, Book book) {
        bookManager.addBook(isbn, book);
    }

    public void addMember(String memberId) {
        memberManager.addMember(memberId, new Member(memberId));
    }

    public boolean borrowBook(String memberId, String isbn) {
        if (!bookManager.isBookAvailable(isbn)) {
            bookManager.addToWaitlist(isbn, memberId);
            return false;
        }
        if (memberManager.getLastTransaction(memberId) != null && memberManager.getLastTransaction(memberId).getType().equals("BORROW")) {
            return false;
        }

        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Transaction t = new Transaction(memberId, isbn, "BORROW", time);

        bookManager.setBookAvailability(isbn, false);
        memberManager.recordTransaction(memberId, t);
        transactionManager.addTransaction(t);

        return true;
    }

    public boolean returnBook(String memberId, String isbn) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Transaction t = new Transaction(memberId, isbn, "RETURN", time);

        bookManager.setBookAvailability(isbn, true);
        memberManager.recordTransaction(memberId, t);
        transactionManager.addTransaction(t);

        if (bookManager.hasWaitlist(isbn)) {
            String next = bookManager.getNextFromWaitlist(isbn);
            borrowBook(next, isbn);
        }
        return true;
    }

    public Transaction getLastTransaction(String memberId) {
        return memberManager.getLastTransaction(memberId);
    }

    public Transaction getTransaction(int index) {
        return transactionManager.getTransactionByIndex(index);
    }
}