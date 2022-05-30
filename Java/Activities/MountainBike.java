package activities;

public class MountainBike extends Bicycle{
    //new variable in the MountainBike class
    public int seatHeight;

    //Constructor
    public MountainBike(int gears, int currentSpeed, int startHeight){
        super(gears, currentSpeed); //calling the super class constructor
        this.seatHeight = startHeight;
    }

    //new method in the Mou ntainBike class
    public void setHeight(int newValue) {
        this.seatHeight = newValue;
    }

    //Method overriding
    public String bicycleDesc() {
        String desc = "No of gears = "+ gears + " & Speed of bicycle is " + currentSpeed + " & seat height = " +seatHeight;
        return desc;
    }

}
