package com;


// import java.util.ArrayList;
// import java.util.List;

import com.characters.*;
import com.model.*;

public class Main{
    public static void main(String[] args){
        Home home = new Home();

        FrekenBock frekenBock = new FrekenBock(Name.FREKEN_BOCK, home, "It was the excitement of yesterday's bakery and pancake taming");
        home.addResident(frekenBock.getName());
        UncleJulius uncleJulius = new UncleJulius(Name.UNCLE_JULIUS, home, "Didn't sleep well last night and then spent the hole day on feet");
        home.addResident(uncleJulius.getName());
        Kid kid = new Kid(Name.KID);
        home.addResident(kid.getName());
        Mother mother = new Mother(Name.MOTHER);
        home.addResident(mother.getName());
        Carlson carlson = new Carlson(Name.CARLSON);
        home.addResident(carlson.getName());

        home.randomSattle();//show settle will be inside random and create and manage?
        mother.createIdealSettle(home);
        mother.manageSettlement(home);

        uncleJulius.showTirednessReason();
        uncleJulius.kissGoodNight();
        uncleJulius.goToSleep();

        frekenBock.showTirednessReason();
        frekenBock.kissGoodNight();
        frekenBock.goToSleep();

        carlson.listenToHallwayNoise(home);
        System.out.println(carlson.toString());//just for check
        System.out.println(home.toString());//just for check
        
    }
}