package controllers;

public class Program {

    public static void main(String[] args){

        WestminsterLibraryManager manager = new WestminsterLibraryManager();
        for (int i=0; i<manager.bookArrayList.size(); i++){
            System.out.println(manager.bookArrayList.get(i).toString());
        }
    }
}
