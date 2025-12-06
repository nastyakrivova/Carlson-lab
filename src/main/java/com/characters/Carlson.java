package com.characters;

import com.model.*;

public class Carlson extends Person{
    // public Carlson(Name name, Home home){
    //     super(name);
    // }

    public Carlson(Name name){
        super(name);
    }

    public void listenToHallwayNoise(Home home){
        if(home.getNoiseInHallway()){
            System.out.println("Carlson hears footsteps in the hallway and hides in a closet");
        }
    }
}