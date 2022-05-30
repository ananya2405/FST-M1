package activities;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        MountainBike newBike = new MountainBike(3,0,25);

        //Printing the bike description from the child class
        System.out.println(newBike.bicycleDesc());

        //Speed after acceleration
        newBike.speedUp(20);

        //Speed after pressing brake
        newBike.applyBrake(5);
    }
}
