import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private Map<String, Book> books;
    private Map<String, Boolean> available;

    public BookManager() {
        books = new HashMap<>();
        available = new HashMap<>();
    }

    public void addBook(String isbn, Book book) {
        books.put(isbn, book);
        available.put(isbn, true);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return available.getOrDefault(isbn, false);
    }

    public void setBookAvailability(String isbn, boolean availability) {
        if (books.containsKey(isbn)) {
            available.put(isbn, availability);
        }

    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = books.get(isbn);
        if (book != null) {
            book.add(memberId);
        }
    }

    public String getNextFromWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return book.hasWaitlist();
        }
        return false;
    }
}
