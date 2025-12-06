package com.characters;


import com.model.Home;

public abstract class Person{
    private Name name;
    private boolean isAsleep = false;
    protected Home home;
    public Person(Name name, Home home){
        this.name = name;
        this.home = home;
    }

    public Person(Name name){
        this.name = name;
    }

    public Name getName(){
        return this.name;
    }

    public boolean getIsAsleep(){
        return isAsleep;
    }

    public void setIsAsleep(boolean isAsleep){
        this.isAsleep = isAsleep;
    }

    // public void setHome(Home home){
    //     this.home = home;
    // }
}