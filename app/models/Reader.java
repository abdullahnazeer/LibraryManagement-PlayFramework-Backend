package models;

public class Reader {

    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private Integer memberID;

    public Reader(String firstName, String lastName, String email, String contact, Integer memberID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", memberID=" + memberID +
                '}';
    }

    public Integer getMemberID() {
        return memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

}
