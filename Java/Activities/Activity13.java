package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.print("Please enter integers: ");

        //To accept numbers from user and storing it in the arraylist
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        //Converting arraylist into an array
        Integer[] nums = list.toArray(new Integer[0]);

        //Generating a random index
        int index = indexGen.nextInt(nums.length);
        System.out.println("Index value generated: " + index);

        //Printing the user inputted value using the above index from the array
        System.out.println("Value in array at generated index: " + nums[index]);
        scan.close();

    }

}
