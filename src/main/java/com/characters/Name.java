package com.characters;

public enum Name{
    FREKEN_BOCK("Freken Bock"),
    UNCLE_JULIUS("uncle Julius"),
    KID("Kid"),
    CARLSON("Carlson"),
    MOTHER("Mother");

    private final String name;
    private Name(String name){
        this.name = name;
    }

    public String getName(){ return name;}

    @Override
    public String toString(){
        return name;
    }
}