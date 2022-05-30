package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
    public int gears;
    public int currentSpeed;

    //Constructor
    public Bicycle(int gears, int currentSpeed){
        this.gears = gears;
        this.currentSpeed=currentSpeed;
    }

    //Implementing the methods of the implemented interface
    @Override
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed-decrement;
        System.out.println("Current speed after pressing brake = "+currentSpeed);
    }
    @Override
    public void speedUp(int increment) {
        currentSpeed = currentSpeed+increment;
        System.out.println("Current speed after acceleration = "+currentSpeed);

    }

    // Method to describe the bycicle
    public String bicycleDesc() {
        String desc = "No of gears = "+ gears + " & Speed of bicycle is " + currentSpeed;
        return desc;
    }
}
