package com.exceptions;

public class HomeNotInitializedException extends RuntimeException{
    public HomeNotInitializedException(String massage){
        super(massage);
    }
}