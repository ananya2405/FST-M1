package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] numbers = {45, 44, 32, 29, 49, 3};

        System.out.println("Array before sorting = " + Arrays.toString(numbers));

        //Sorting logic in ascending order
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    temp=numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;

                }
            }
        }
     System.out.println("Array after sorting in ascending order= "+Arrays.toString(numbers));
}
    }

