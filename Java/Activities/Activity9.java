package activities;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();

        //Adding objects in the arraylist
        myList.add("Nokia");
        myList.add("Samsung");
        myList.add("Realme");
        myList.add("Motorola");
        myList.add("LG");

        getList(myList);

        System.out.println("The 3rd element in the list is = " +myList.get(3));
        System.out.println("Is Nokia exist in the list? = "+myList.contains("Nokia"));
        System.out.println("The size of the arraylist before removal = "+ myList.size());
        myList.remove("Realme");
        System.out.println("The size of the arraylist after removal = "+ myList.size());

    }

    //To print all the items from the arraylist
    public static void getList(ArrayList<String> list){
        for(String name:list){
            System.out.println("The items are = "+name);
        }
    }


}
