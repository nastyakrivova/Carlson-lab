package com.model;

import java.util.*;

import com.characters.*;
import com.exceptions.*;

public class Home{

    private boolean isNoiseInHallway = false;
    private Map<Name, Room> currentSettlement = new HashMap<>();
    private IdealSettle idealSettle;
    private List<Name> residents = new ArrayList<>();



    public void addResident(Name name){
        if (name == null){
            throw new IllegalArgumentException("Name can not be null");
        }
        residents.add(name);
    }



    public void randomSattle(){
        if (residents.isEmpty()){
            throw new HomeNotInitializedException("Residents of home were not initialized yet");
        }

        Random randon = new Random();
        Room[] rooms = Room.values();
        for(Name person: residents){
            Room randomRoom = rooms[randon.nextInt(rooms.length)];
            currentSettlement.put(person, randomRoom);
        }

        System.out.println("Charaters are randomly placed in rooms: " + this.currentSettlement);
    }



    public void setIdealSettle(Map<Name, Room> idealSettle){
        if (idealSettle.isEmpty()){
            throw new IllegalArgumentException("Ideal settlement map can not be null");
        }
        this.idealSettle = new IdealSettle(idealSettle);
    }



    public boolean checkIfCurrIsIdeal(){
        if (idealSettle == null){
            throw new HomeNotInitializedException("Ideal settlement of home was not initialized yet");
        }
        Map<Name, Room> ideal = idealSettle.idealSettle();
        return currentSettlement.equals(ideal);
    }



    public void changeCurrSettle() throws CharacterNotResidentException{
        if (idealSettle == null){
            throw new HomeNotInitializedException("Ideal settlement of home was not initialized yet");
        }
        Map<Name, Room> ideal = idealSettle.idealSettle();

        List<Name> residentsNotInIdealSettle = new ArrayList<>();
        for(Name resident: residents){
            if(!ideal.containsKey(resident)){
                residentsNotInIdealSettle.add(resident);
            }
        }
        if(!residentsNotInIdealSettle.isEmpty()){
            throw new CharacterNotResidentException("Some residents missing in ideal settlement" + residentsNotInIdealSettle, residentsNotInIdealSettle);
        }

        this.currentSettlement = new HashMap<>(ideal);
        System.out.println("Mother changed initial settlement: " + this.currentSettlement);
    }



    public boolean getNoiseInHallway(){
        return this.isNoiseInHallway;
    }

    public void setNoiseInHallway(boolean isNoiseInHallway){
        this.isNoiseInHallway = isNoiseInHallway;
    }

    public Map<Name, Room> getIdealSettle(){
        return idealSettle.idealSettle();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(currentSettlement, home.currentSettlement) &&
                Objects.equals(residents, home.residents) &&
                Objects.equals(idealSettle, home.idealSettle) &&
                Objects.equals(isNoiseInHallway, home.isNoiseInHallway); 
    }

    @Override
    public int hashCode(){
        return Objects.hash(currentSettlement, residents, idealSettle, isNoiseInHallway);
    }

    @Override
    public String toString(){
        return "Home{ currentSettlement: " + currentSettlement.toString() +
                "residents: " + residents.toString() +
                "idealSettle: " + idealSettle.toString() +
                "isNoiseInHallway" + isNoiseInHallway + " }";
    }
}