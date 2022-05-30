package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args)  {
        HashSet<String> hs = new HashSet<String>();

        //Adding objects to hashset
        hs.add("Apple");
        hs.add("Mango");
        hs.add("Goava");
        hs.add("Banana");
        hs.add("Cucumber");
        hs.add("Orange");

        //printing the size of the hashset
        System.out.println("The size of the hashset is = "+ hs.size());

        //Removing one item
        hs.remove("Cucumber");

        //Remove the item if it is present in the hashset
        if(hs.contains("lime")){
            hs.remove("lime");
            System.out.println("Lime is removed from the set");
        }
        else System.out.println("Lime is not present in the set");

        //Check if an item is present in the hashset
        System.out.println("Is Mango in the list? = "+ hs.contains("Mango"));

        //Check the size of the hashset after removing an item
        System.out.println("The new size of the hashset is = "+ hs.size());

    }
}
