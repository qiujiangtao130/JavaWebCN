package Domain;

public class BOOK {
    private String BID;
    private String title;

    public BOOK() {
    }

    private String author;
    public BOOK(String BID, String title, String author) {
        this.BID = BID;
        this.title = title;
        this.author = author;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BOOK{" +
                "BID='" + BID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
