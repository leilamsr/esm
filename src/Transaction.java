public class Transaction {
    private String member;
    private String isbn;
    private String type;
    private String timestamp;

    public Transaction(String member, String isbn, String type, String timestamp) {
        this.member = member;
        this.isbn = isbn;
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
