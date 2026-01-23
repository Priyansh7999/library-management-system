public class Book {
    private String bookId;
    private String title;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, int copies) {
        this.title = title;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    // to display particular book info
    public String displayInfo() {
        return title + " | Available: " + availableCopies + "/" + totalCopies;
    }
}
