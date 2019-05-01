package models;

public class Book extends LibraryItem {

    private String authors;
    private String publisher;
    private Integer noOfPages;
    private Reader reader;

    public Book(String ISBN, String title, String sector, String publicationDate, DateTime borrowedDateTime, String authors, String publisher, Integer noOfPages, Reader reader) {
        super(ISBN, title, sector, publicationDate, borrowedDateTime);
        this.authors = authors;
        this.publisher = publisher;
        this.noOfPages = noOfPages;
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + super.getISBN() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", sector='" + super.getSector() + '\'' +
                ", publicationDate='" + super.getPublicationDate() + '\'' +
                ", authors='" + authors + '\'' +
                ", publisher='" + publisher + '\'' +
                ", noOfPages=" + noOfPages +
                '}';
    }

    public String getAuthors() {
        return authors;
    }


    public String getPublisher() {
        return publisher;
    }

    public Integer getNoOfPages() {
        return noOfPages;
    }

    public Reader getReader() { return reader; }

    public void setReader(Reader reader) { this.reader = reader; }
}
