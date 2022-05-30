package activities;

//The MyBook class, extending the Book class that is abstract
public class MyBook extends Book{

    //Implementing the abstract method
    @Override
    public void setTitle(String val) {
        title = val;
    }
}
