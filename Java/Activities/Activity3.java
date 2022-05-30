package activities;

import java.text.DecimalFormat;

public class Activity3 {
    public static void main(String[] args){

    //Actual age in second
    double seconds = 1000000000;

    //Orbital periods of Earth in seconds
    double EarthSeconds = 31557600;

    //Orbital periods of various planets Earth years
    double MercurySeconds = 0.2408467;
    double VenusSeconds = 0.61519726;
    double MarsSeconds = 1.8808158;
    double JupiterSeconds = 11.862615;
    double SaturnSeconds = 29.447498;
    double UranusSeconds = 84.016846;
    double NeptuneSeconds = 164.79132;

    //Printing the same age in various planets:
    System.out.println("Age on Earth = "+ getAge(seconds,EarthSeconds));
    System.out.println("Age on Mercury = "+ getAge(seconds,EarthSeconds,MercurySeconds));
    System.out.println("Age on Venus = "+ getAge(seconds,EarthSeconds,VenusSeconds));
    System.out.println("Age on Mars = "+ getAge(seconds,EarthSeconds,MarsSeconds));
    System.out.println("Age on Jupiter = "+ getAge(seconds,EarthSeconds,JupiterSeconds));
    System.out.println("Age on Saturn = "+ getAge(seconds,EarthSeconds,SaturnSeconds));
    System.out.println("Age on Uranus = "+ getAge(seconds,EarthSeconds,UranusSeconds));
    System.out.println("Age on Neptune = "+ getAge(seconds,EarthSeconds,NeptuneSeconds));
    }

    //overloaded methods to get age for various planets
    public static String getAge(double ageInSec, double orbitalPeriod){
       DecimalFormat f = new DecimalFormat("##.00");
       double age = ageInSec/orbitalPeriod;
       return f.format(age);

    }
    public static String getAge(double ageInSec, double orbitalPeriod, double planetOrbitalPeriod){
        DecimalFormat f = new DecimalFormat("##.00");
        double age = ageInSec/(orbitalPeriod*planetOrbitalPeriod);
        return f.format(age);

    }
}
