package activities;

public class Car {
    // declaring the member variable
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    //Constructor
    public Car(int mk, String clr, String tr){
        this.tyres = 4;
        this.doors = 4;
        make=mk;
        transmission=tr;
        color=clr;


    }
    //Method to display the car characteristics
    public void displayCharacteristics(){
        System.out.println("Make is = " +make);
        System.out.println("Color is = "+color);
        System.out.println("Transmission is = "+transmission);
        System.out.println("Tyre count = "+tyres);
        System.out.println("Door count = "+doors);

    }
    //Method to accelerate
    public void accelarate(){
        System.out.println("Car is moving forward.");
    }

    //Method to brake
    public void brake(){
        System.out.println("Car has stopped.");
    }
}
