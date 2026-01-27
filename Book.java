public class Book {
    private String bookId;
    private String title;

    public Book(String title, int copies) {
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
