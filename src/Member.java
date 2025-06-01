import java.util.LinkedList;

public class Member {
    private String memberId;
    private LinkedList<Transaction> transactions;

    public Member(String memberId) {
        this.memberId = memberId;
        transactions = new LinkedList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        if (transactions.isEmpty()) {
            return null;
        }
        return transactions.getLast();
    }

    public String getMemberId() {
        return memberId;
    }
}
