package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args)  {
        HashMap<Integer, String> colours = new HashMap<Integer, String>();

        //Adding objects in the hashmap with key
        colours.put(0,"Red");
        colours.put(1,"Black");
        colours.put(2,"Blue");
        colours.put(3,"Orange");
        colours.put(4,"Yellow");

        //Printing the hashmap objects and its size
        System.out.println("The map is = "+ colours);
        System.out.println("The size of the map is = "+ colours.size());

        //Removing one item using its key
        colours.remove(1);

        //Checking if green color is present
        if(colours.containsValue("green")){
            System.out.println("Green is available");
        }
        else System.out.println("Green is not available");

        //Printing new size of the map, after removing an item
        System.out.println("New size of the map is = "+ colours.size());
    }
}
