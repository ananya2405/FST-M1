package activities;

public class Activity5 {
    public static void main(String[] args) {
        //Instantiating object of MyBook class
        MyBook newNovel = new MyBook();

        //Setting the book title
        newNovel.setTitle("My Title");

        //Printing the title
        System.out.println("The title of the book is: " + newNovel.getTitle());
    }
}
