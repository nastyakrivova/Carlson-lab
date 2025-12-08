package com.exceptions;
import com.characters.*;
import java.util.*;

public class CharacterNotResidentException extends Exception{
    private final List<Name> missingResidents;

    public CharacterNotResidentException(String massage, List<Name> residentsNotInIdealSettle){
        super(massage);
        this.missingResidents = residentsNotInIdealSettle;
    }

    public List<Name> getMissingResidents() {
        return missingResidents;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + "missing residents: " + missingResidents.toString();
    }
}