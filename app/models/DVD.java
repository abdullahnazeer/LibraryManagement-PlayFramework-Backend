package models;

public class DVD extends LibraryItem{

    private String languages;
    private String subtitles;
    private String producer;
    private String actors;
    private Reader reader;

    public DVD(String ISBN, String title, String sector, String publicationDate, DateTime borrowedDateTime, String languages, String subtitles, String producer, String actors) {
        super(ISBN, title, sector, publicationDate, borrowedDateTime);
        this.languages = languages;
        this.subtitles = subtitles;
        this.producer = producer;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "ISBN='" + super.getISBN() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", sector='" + super.getSector() + '\'' +
                ", publicationDate='" + super.getPublicationDate() + '\'' +
                ", languages='" + languages + '\'' +
                ", subtitles='" + subtitles + '\'' +
                ", producer='" + producer + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }

    public String getLanguages() {
        return languages;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public String getActors() {
        return actors;
    }

    public Reader getReader() { return reader; }

    public void setReader(Reader reader) { this.reader = reader; }
}
