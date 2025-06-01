public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book();
        Book book2 = new Book();
        library.addBook("01", book1);
        library.addBook("02", book2);

        library.addMember("1");
        library.addMember("2");
        library.addMember("3");

        library.borrowBook("1", "01");
        library.borrowBook("1", "02");
        library.borrowBook("2", "02");

        library.getLastTransaction("1");
        library.getLastTransaction("2");

        library.returnBook("1", "01");

        library.borrowBook("3", "01");
    }
}