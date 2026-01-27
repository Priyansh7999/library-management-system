public class Book {
    private String id;
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getBookId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
