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
    void createFrekenBock() {
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
    void kissGoodNightWithNullHome(){
        FrekenBock frekenBockNoHome = new FrekenBock(Name.FREKEN_BOCK);
        assertDoesNotThrow(() -> frekenBockNoHome.kissGoodNight());
    }

    @Test
    void testShowTirednessReason() {
        assertDoesNotThrow(() -> frekenBock.showTirednessReason());
    }
}
