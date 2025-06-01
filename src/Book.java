import java.util.Queue;
import java.util.LinkedList;

public class Book {
    private Queue<String> waitlist;

    public Book() {
        waitlist = new LinkedList<>();
    }

    public void add(String member) {
        waitlist.add(member);
    }

    public String getNextInWaitlist() {
        return waitlist.poll();
    }

    public boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }
}
