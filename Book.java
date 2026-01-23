public class Book {
    private String bookId;
    private String title;
    private int totalCopies;

    public Book(String title, int copies) {
        this.title = title;
        this.totalCopies = copies;
    }

    public String getBookId(){
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
