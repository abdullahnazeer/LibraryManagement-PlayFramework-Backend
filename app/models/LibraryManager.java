package models;

import play.mvc.Result;

public interface LibraryManager {

    public Result insertMember();

    public Result insertBook();

    public Result insertDVD();

    public Result deleteBook();

    public Result deleteDVD();

    public Result deleteMember();

    public Result borrowBook();

    public Result borrowDVD();

    public Result returnBook();

    public Result returnDVD();

    public Result reserveBook();

    public Result reserveDVD();
}
