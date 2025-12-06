package com.characters;

import com.interfaces.BeforBedRoutine;
import com.model.Home;

public class FrekenBock extends Person implements BeforBedRoutine{
    private String tirednessReason;

    public FrekenBock(Name name, Home home, String tirednessReason){
        super(name, home);
        this.tirednessReason = tirednessReason;
    }

    public FrekenBock(Name name){
        super(name);
    }

    @Override
    public void kissGoodNight(){
        System.out.println("Freken Bock is coming to say goodnight to Kid");
        if (home != null){
            home.setNoiseInHallway(true);
        }
    }

    @Override
    public void goToSleep(){
        System.out.println("Freken Bock is going to bed");
        setIsAsleep(true);;
    }

    public void showTirednessReason(){
        System.out.println("Freken Bock is tired because: " + this.tirednessReason);
    }
}