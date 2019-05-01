package models;

public class Reserved {

    private String ISBN;
    private int memberID;

    public Reserved(String ISBN, int memberID){
        this.ISBN = ISBN;
        this.memberID = memberID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
