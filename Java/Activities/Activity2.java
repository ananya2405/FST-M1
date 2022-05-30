package activities;

public class Activity2 {
    public static void main(String[] args) {
        //Initializing the array while declaration
        int[] arr = {10, 77, 10, 54, -11, 10};
        int sum = 0;

        //Expected sum
        int expSum=30;

        //The constant number for calculation
        int ConstNumber = 10;
        System.out.println("The result is = " + result(arr,expSum, ConstNumber));
    }

    //Validating the actual sum of the multiple entries of the constant number in the array
    public static Boolean result(int[] arr, int sum, int num) {
        int actSum=0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == num) {
                actSum = actSum + arr[i];
            }
        }
            System.out.println("The sum is = " + sum);
            return (actSum == sum);


    }

}