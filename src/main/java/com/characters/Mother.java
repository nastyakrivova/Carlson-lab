package com.characters;
import com.exceptions.CharacterNotResidentException;

import com.model.*;
import java.util.*;

public class Mother extends Person{

    public Mother(Name name){
        super(name);
    }

    public void manageSettlement(Home home){
        try{
            if(!home.checkIfCurrIsIdeal()){
            home.changeCurrSettle();
            }
        }catch(CharacterNotResidentException e){
            System.out.println(e.getMessage());
            List<Name> missing = e.getMissingResidents();
            fixIdealSettle(missing, home);
        }
        
    }



    public void createIdealSettle(Home home){
        Map<Name, Room> idealSettle = new HashMap<>();
        idealSettle.put(Name.MOTHER, Room.BEDROOM);
        idealSettle.put(Name.KID, Room.KIDROOM);
        idealSettle.put(Name.CARLSON, Room.KIDROOM);
        idealSettle.put(Name.UNCLE_JULIUS, Room.LIVINGROOM);
        idealSettle.put(Name.FREKEN_BOCK, Room.BETANROOM);

        
        home.setIdealSettle(idealSettle);
        System.out.println("Mother came up with settlement plan: " + idealSettle);
    }



    private void fixIdealSettle(List<Name> missing, Home home){
        Map<Name, Room> ideal = home.getIdealSettle();
        Map<Name, Room> newIdeal = new HashMap<>(ideal);

        for (Name person: missing){
            newIdeal.put(person, Room.LIVINGROOM);
        }
        home.setIdealSettle(newIdeal);
    }
}