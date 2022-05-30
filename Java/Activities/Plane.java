package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    //Constructor
    public Plane(int maxPassengers){
        this.passengers = new ArrayList();
        this.maxPassengers=maxPassengers;
        this.lastTimeTookOf = new Date();
        this.lastTimeLanded = new Date();
    }

    //Method for onboarding
    public void onboard(String name){
        this.passengers.add(name);
    }

    //Method for takeoff
    public Date takeOff(){
         return this.lastTimeTookOf;
    }

    //Method for land
    public void land(){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    //Method to get the landed time
    public Date getLastTimeLanded(){
        return this.lastTimeLanded;
    }

    //Method to get the passenger list
    public List<String> getPassengers(){
        return this.passengers;
    }
}
