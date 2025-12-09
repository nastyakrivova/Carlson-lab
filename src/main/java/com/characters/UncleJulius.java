package com.characters;

import java.util.Objects;

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
        if (home != null){
            home.setNoiseInHallway(false);
        }
    }

    public void showTirednessReason(){
        System.out.println("Uncle Julius is tired because: " + this.tirednessReason);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)){return false;}
        UncleJulius person = (UncleJulius) o;
        return tirednessReason.equals(person.tirednessReason); 
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), tirednessReason);
    }

    @Override
    public String toString(){
        return "UncleJulius{ " + super.toString() + "tirednessReason: " + tirednessReason + " }";
    }
}