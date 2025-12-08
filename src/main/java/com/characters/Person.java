package com.characters;

import java.util.Objects;

import com.model.Home;

public abstract class Person{
    private Name name;
    private boolean isAsleep = false;
    protected Home home;//protected because mother
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && home.equals(person.home); 
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, home);
    }

    @Override
    public String toString(){
        return name.toString();
    }
}