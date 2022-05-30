package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car maruti = new Car(2014, "Black", "Manual");

        //Calling the Car class methods using its object
        maruti.displayCharacteristics();
        maruti.accelarate();
        maruti.brake();
    }
}
