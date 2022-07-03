package activities;

public class Activity8 {
    public static void main(String[] args) {
        try {
            
            //calling method with valid string
            exceptionTest("This is a valid value");
            
            //calling method with null which will throw the custom exception
            exceptionTest(null);

        } catch (CustomException e) {
            System.out.println("The customer exception message = "+e.getMessage());
        }
    }

    public static void exceptionTest(String value) throws CustomException {
        if(value==null) {
            throw new CustomException("Value is null");
        }
        else System.out.println(value);
    }
}
