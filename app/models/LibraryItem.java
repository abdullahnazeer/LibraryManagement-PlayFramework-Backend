package models;

public abstract class LibraryItem {

    private String ISBN;
    private String title;
    private String sector;
    private String publicationDate;
    private DateTime borrowedDateTime;

    public LibraryItem(String ISBN, String title, String sector, String publicationDate, DateTime borrowedDateTime){
        this.ISBN = ISBN;
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
        this.borrowedDateTime = borrowedDateTime;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public DateTime getBorrowedDateTime() {
        return borrowedDateTime;
    }

    public void setBorrowedDateTime(DateTime borrowedDateTime) {
        this.borrowedDateTime = borrowedDateTime;
    }
}
