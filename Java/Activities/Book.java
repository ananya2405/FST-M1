package activities;

public abstract class Book {
    String title;

    //abstract method with no implementation body
    public abstract void setTitle(String val) ;

    //Concrete method with method body
    public String getTitle() {
        return title;
    }
    }