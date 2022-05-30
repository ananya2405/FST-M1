package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        //Creating object of plane with 5 passengers
        Plane plane = new Plane(5);

        //Listing the passengers
        plane.onboard("Abc");
        plane.onboard("def");
        plane.onboard("ghi");
        plane.onboard("jkl");
        plane.onboard("mno");

        //Plane takes off
        System.out.println("Take off time = "+ plane.takeOff());

        //Passenger list during take off
        System.out.println("Passenger list = "+ plane.getPassengers());

        //Flying time
        Thread.sleep(5000);

        //Plane lands
        plane.land();

        //Time after landing
        System.out.println("Take off time = "+ plane.getLastTimeLanded());

        //Passenger list in the plane after landing
        System.out.println("Passengers on the plane after landing= "+ plane.getPassengers());

    }
}
