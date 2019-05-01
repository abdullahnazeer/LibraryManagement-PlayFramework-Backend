package controllers;

import models.*;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Calendar;


public class WestminsterLibraryManager extends Controller implements LibraryManager {

    ArrayList<Book> bookArrayList = new ArrayList<>();
    ArrayList<DVD> dvdArrayList = new ArrayList<>();
    ArrayList<Reader> memberArrayList = new ArrayList<>();
    ArrayList<Reserved> reservedArrayList = new ArrayList<>();
    double overdueFine = 0;

    public Result insertMember() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String firstName = json.get("firstName").asText();
            String lastName = json.get("lastName").asText();
            String email = json.get("email").asText();
            String contact = json.get("contact").asText();
            Integer memberID = json.get("memberID").asInt();
            Reader member = new Reader(firstName, lastName, email, contact, memberID);
            memberArrayList.add(member);
            return ok("Member added!");

        }
    }

    public Result insertBook() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String bookISBN = json.get("ISBN").asText();
            String bookTitle = json.get("title").asText();
            String bookSector = json.get("sector").asText();
            String bookPublicationDate = json.get("publicationDate").asText();
            String authors = json.get("authors").asText();
            String publisher = json.get("publisher").asText();
            Integer noOfPages = json.get("noOfPages").asInt();
            Book book = new Book(bookISBN, bookTitle, bookSector, bookPublicationDate, null, authors, publisher, noOfPages, null);
            if (bookArrayList.size() <= 100) {
                bookArrayList.add(book);
                return ok("Book added!");
            } else {
                return ok("Book limit reached!");
            }
        }
    }

    public Result insertDVD() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String dvdISBN = json.get("ISBN").asText();
            String dvdTitle = json.get("title").asText();
            String dvdSector = json.get("sector").asText();
            String dvdPublicationDate = json.get("publicationDate").asText();
            String languages = json.get("languages").asText();
            String subtitles = json.get("subtitles").asText();
            String producer = json.get("producer").asText();
            String actors = json.get("actors").asText();

            DVD dvd = new DVD(dvdISBN, dvdTitle, dvdSector, dvdPublicationDate, null, languages, subtitles, producer, actors);
            if (dvdArrayList.size() <= 50) {
                dvdArrayList.add(dvd);
                return ok("Connection Established! DVD Added!");
            } else {
                return ok("DVD limit reached!");
            }


        }
    }

    public Result deleteBook() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String bookISBN = json.get("ISBN").asText();
            if (bookISBN == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= bookArrayList.size(); i++) {
                    if (bookArrayList.get(i).getISBN().equals(bookISBN)) {
                        bookArrayList.remove(i);
                    } else return ok("No book found!");
                }
            }

        }
        return ok("Delete book works!");
    }

    public Result deleteDVD() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String dvdISBN = json.get("ISBN").asText();
            if (dvdISBN == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= dvdArrayList.size(); i++) {
                    if (dvdArrayList.get(i).getISBN().equals(dvdISBN)) {
                        dvdArrayList.remove(i);
                    } else return ok("No DVD found!");
                }
            }

        }
        return ok("Delete DVD works!");
    }

    public Result deleteMember() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String memberID = json.get("memberID").asText();
            if (memberID == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= memberArrayList.size(); i++) {
                    if (memberArrayList.get(i).getMemberID().equals(memberID)) {
                        memberArrayList.remove(i);
                    } else return ok("No Member found!");
                }
            }

        }
        return ok("Delete Member works!");
    }

    public Result borrowBook() {
        Calendar calendar = Calendar.getInstance();
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String bookISBN = json.get("ISBN").asText();
            Integer memberID = json.get("memberID").asInt();
            if (bookISBN == null || memberID == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= memberArrayList.size(); i++) {
                    if (memberArrayList.get(i).getMemberID().equals(memberID)) {
                        for (int j = 0; j <= bookArrayList.size(); j++) {
                            if (bookArrayList.get(j).getISBN().equals(bookISBN)) {
                                bookArrayList.get(j).setReader(memberArrayList.get(i));
                                bookArrayList.get(j).setBorrowedDateTime(new DateTime(calendar.get(Calendar.DAY_OF_MONTH),
                                        calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.DAY_OF_YEAR)));
                                return ok(bookArrayList.get(j).toString());
                            }
                        }
                    }
                }
            }

        }
        return ok("Book Has Been Issued!");
    }

    public Result borrowDVD() {
        Calendar calendar = Calendar.getInstance();
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String dvdISBN = json.get("ISBN").asText();
            Integer memberID = json.get("memberID").asInt();
            if (dvdISBN == null || memberID == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= memberArrayList.size(); i++) {
                    if (memberArrayList.get(i).getMemberID().equals(memberID)) {
                        for (int j = 0; j <= dvdArrayList.size(); j++) {
                            if (dvdArrayList.get(j).getISBN().equals(dvdISBN)) {
                                dvdArrayList.get(j).setReader(memberArrayList.get(i));
                                dvdArrayList.get(j).setBorrowedDateTime(new DateTime(calendar.get(Calendar.DAY_OF_MONTH),
                                        calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.DAY_OF_YEAR)));
                                return ok(dvdArrayList.get(j).toString());
                            }
                        }
                    }
                }
            }

        }
        return ok("DVD Has Been Issued!");
    }

    public Result returnBook() {
        double borrowedDay;
        Calendar calendar = Calendar.getInstance();
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String bookISBN = json.get("ISBN").asText();
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            for (int i = 0; i < bookArrayList.size(); i++) {
                if (bookISBN.equals(bookArrayList.get(i).getISBN())) {
                    borrowedDay = bookArrayList.get(i).getBorrowedDateTime().getDayOfYear();
                    if ((dayOfYear - borrowedDay) > 7 && (dayOfYear - borrowedDay) <= 10) {
                        overdueFine = (3 * 24 * 0.2);
                    } else if ((dayOfYear - borrowedDay) > 10) {
                        overdueFine = (3 * 24 * 0.2) + ((dayOfYear - borrowedDay - 10) * 24 * 0.5);
                    }
                }
            }
            return ok("Fine Payable :" + overdueFine);
        }
    }

    public Result returnDVD() {
        double borrowedDay;
        Calendar calendar = Calendar.getInstance();
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String dvdISBN = json.get("ISBN").asText();
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            for (int i = 0; i < dvdArrayList.size(); i++) {
                if (dvdISBN.equals(dvdArrayList.get(i).getISBN())) {
                    borrowedDay = dvdArrayList.get(i).getBorrowedDateTime().getDayOfYear();
                    if ((dayOfYear - borrowedDay) > 3 && (dayOfYear - borrowedDay) <= 6) {
                        overdueFine = (3 * 24 * 0.2);
                    } else if ((dayOfYear - borrowedDay) > 6) {
                        overdueFine = (3 * 24 * 0.2) + ((dayOfYear - borrowedDay - 10) * 24 * 0.5);
                    }
                }
            }
            return ok("Fine Payable:" + overdueFine);
        }

    }

    public Result reserveBook() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String bookISBN = json.get("ISBN").asText();
            Integer memberID = json.get("memberID").asInt();
            if (bookISBN == null || memberID == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= bookArrayList.size(); i++) {
                    if (memberArrayList.get(i).getMemberID().equals(memberID)) {
                        for (int j = 0; j <= bookArrayList.size(); j++) {
                            if (bookArrayList.get(j).getISBN().equals(bookISBN)) {
                                bookArrayList.remove(j);
                                reservedArrayList.add(new Reserved(bookISBN, memberID));
                            }
                        }
                    }
                }
            }

        }
        return ok("Book Has Been Reserved!");
    }

    public Result reserveDVD() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting JSON Data!");
        } else {
            String dvdISBN = json.get("ISBN").asText();
            Integer memberID = json.get("memberID").asInt();
            if (dvdISBN == null || memberID == null) {
                return badRequest("Missing parameter(s)");
            } else {
                for (int i = 0; i <= dvdArrayList.size(); i++) {
                    if (memberArrayList.get(i).getMemberID().equals(memberID)) {
                        for (int j = 0; j <= dvdArrayList.size(); j++) {
                            if (dvdArrayList.get(j).getISBN().equals(dvdISBN)) {
                                dvdArrayList.remove(j);
                                reservedArrayList.add(new Reserved(dvdISBN, memberID));
                            }
                        }
                    }
                }
            }

        }
        return ok("Book Has Been Reserved!");
    }

}
