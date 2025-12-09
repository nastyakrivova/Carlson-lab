package com.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.model.*;

public class FrekenBockTest {
    private FrekenBock frekenBock;
    private Home mockHome;
    private String tirednessReason;

    @BeforeEach
    void setUp(){
        tirednessReason = "didn't sleap enough";
        mockHome = mock(Home.class);
        frekenBock = new FrekenBock(Name.FREKEN_BOCK, mockHome, tirednessReason);
    }

    @Test
    void testCreateFrekenBock() {
        assertNotNull(frekenBock);
    }

    @Test
    void testGoToSleep() {
        assertDoesNotThrow(() -> frekenBock.goToSleep());
    }

    @Test
    void testKissGoodNight() {
        frekenBock.kissGoodNight();
        verify(mockHome).setNoiseInHallway(true);
    }

    @Test 
    void testKissGoodNightWithNullHome(){
        FrekenBock frekenBockNoHome = new FrekenBock(Name.FREKEN_BOCK);
        assertDoesNotThrow(() -> frekenBockNoHome.kissGoodNight());
    }

    @Test
    void testShowTirednessReason() {
        assertDoesNotThrow(() -> frekenBock.showTirednessReason());
    }


    @Test
    void testEqualsSameObject() {
        FrekenBock frekenBock2 = new FrekenBock(Name.FREKEN_BOCK, mockHome, tirednessReason);
        assertEquals(frekenBock, frekenBock2);
    }

    @Test
    void testEqualsWhenNull() {
        assertNotEquals(frekenBock, null);
    }

    @Test
    void testEqualsDifferentClass() {
        UncleJulius uncleJulius = new UncleJulius(Name.UNCLE_JULIUS, mockHome, tirednessReason);
        assertNotEquals(frekenBock, uncleJulius);
    }

    @Test
    void testEqualsDifferentTirednessReason() {
        FrekenBock differentFreken = new FrekenBock(Name.FREKEN_BOCK, mockHome, "different reason");
        assertNotEquals(frekenBock, differentFreken);
    }

    @Test
    void testHashCode() {
        FrekenBock frekenBock2 = new FrekenBock(Name.FREKEN_BOCK, mockHome, tirednessReason);
        assertTrue(frekenBock.equals(frekenBock2));
        assertEquals(frekenBock.hashCode(), frekenBock2.hashCode());
    }
}
