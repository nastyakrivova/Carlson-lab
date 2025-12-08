package com.characters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.model.*;

public class CarlsonTest {
    @Test
    void createCarlson(){
        Carlson carlson = new Carlson(Name.CARLSON);
        assertNotNull(carlson);
    }

    @Test
    void testListenToHallwayNoise_ShouldHide() {
        Carlson carlson = new Carlson(Name.CARLSON);
        Home mockHome = mock(Home.class);

        when(mockHome.getNoiseInHallway()).thenReturn(true);
        carlson.listenToHallwayNoise(mockHome);
        verify(mockHome).getNoiseInHallway();
    }

    @Test
    void testListenToHallwayNoise_ShouldNotHide() {
        Carlson carlson = new Carlson(Name.CARLSON);
        Home mockHome = mock(Home.class);

        when(mockHome.getNoiseInHallway()).thenReturn(false);
        carlson.listenToHallwayNoise(mockHome);
        verify(mockHome).getNoiseInHallway();
    }

    @Test
    void testListenToHallwayNoise_NullCheck() {
        Carlson carlson = new Carlson(Name.CARLSON);
        assertDoesNotThrow(() -> carlson.listenToHallwayNoise(null));
    }

}
