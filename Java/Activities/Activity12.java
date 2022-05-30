package activities;

public class Activity12 {
    public static void main(String[] args)  {

        //lambda function without body
        Addable ad1 = (num1, num2) -> (num1 + num2);
        System.out.println("Sum1 = "+ad1.add(15,20));

        //lambda function with body
        Addable ad2 = (int num1, int num2) -> {
            return (num1 + num2);
        };
        System.out.println("Sum2 = "+ad2.add(25,50));

    }
}
