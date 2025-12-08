package com.characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import java.util.*;

import com.exceptions.CharacterNotResidentException;
import com.model.*;

public class MotherTest {

    @Test
    void testCreateIdealSettle() {
        Mother mother = new Mother(Name.MOTHER);
        Home mockHome = mock(Home.class);

        mother.createIdealSettle(mockHome);

        Map<Name, Room> expectedIdealSettle = Map.of(
            Name.MOTHER, Room.BEDROOM,
            Name.KID, Room.KIDROOM,
            Name.CARLSON, Room.KIDROOM,
            Name.UNCLE_JULIUS, Room.LIVINGROOM,
            Name.FREKEN_BOCK, Room.BETANROOM);
        verify(mockHome).setIdealSettle(expectedIdealSettle);
    }

    @Test
    void testManageSettlement_IfCurrIsIdeal() {

        Mother mother = new Mother(Name.MOTHER);
        Home mockHome = mock(Home.class);

        when(mockHome.checkIfCurrIsIdeal()).thenReturn(true);

        assertDoesNotThrow(() -> mother.manageSettlement(mockHome));
        try{
            verify(mockHome, never()).changeCurrSettle();
        }catch(CharacterNotResidentException e){
            fail(e.getMessage());
        }
    }

    @Test
    void testManageSettlement_IfCurrIsNotIdeal(){
        Mother mother = new Mother(Name.MOTHER);
        Home mockHome = mock(Home.class);

        when(mockHome.checkIfCurrIsIdeal()).thenReturn(false);
        assertDoesNotThrow(() -> mother.manageSettlement(mockHome));
        try{
            verify(mockHome).changeCurrSettle();
        }catch(CharacterNotResidentException e){
            fail(e.getMessage());
        }
    }

    @Test
    void testManageSettlement_WithException() throws CharacterNotResidentException{
        Mother mother = new Mother(Name.MOTHER);
        Home mockHome = mock(Home.class);

        when(mockHome.checkIfCurrIsIdeal()).thenReturn(false);
        List<Name> missing = List.of(Name.CARLSON, Name.KID);
        doThrow(new CharacterNotResidentException("Missing residents", missing)).when(mockHome).changeCurrSettle();
        
        mother.manageSettlement(mockHome);

        try{
            verify(mockHome).setIdealSettle(anyMap());
            verify(mockHome, times(2)).changeCurrSettle();
        }catch(CharacterNotResidentException e){
            fail(e.getMessage());
        }
        
    }
}
