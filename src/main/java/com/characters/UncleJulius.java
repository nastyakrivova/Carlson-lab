package com.characters;

import com.interfaces.BeforBedRoutine;
import com.model.Home;

public class UncleJulius extends Person implements BeforBedRoutine{
    private String tirednessReason;

    public UncleJulius(Name name, Home home, String tirednessReason){
        super(name, home);
        this.tirednessReason = tirednessReason;
    }

    public UncleJulius(Name name){
        super(name);
    }

    @Override
    public void kissGoodNight(){
        System.out.println("Uncle Julius is coming to say goodnight to Kid");
        if (home != null){
            home.setNoiseInHallway(true);
        }
    }

    @Override
    public void goToSleep(){
        System.out.println("Uncle Julius is going to bed");
        setIsAsleep(true);;
    }

    public void showTirednessReason(){
        System.out.println("Uncle Julius is tired because: " + this.tirednessReason);
    }
}