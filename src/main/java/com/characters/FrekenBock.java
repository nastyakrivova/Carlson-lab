package com.characters;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)){return false;}
        FrekenBock person = (FrekenBock) o;
        return tirednessReason.equals(person.tirednessReason); 
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), tirednessReason);
    }

    @Override
    public String toString(){
        return "FrekenBock{ " + super.toString() + "tirednessReason: " + tirednessReason + " }";
    }
}