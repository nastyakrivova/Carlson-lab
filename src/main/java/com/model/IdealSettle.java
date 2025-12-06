package com.model;
import java.util.Map;
import com.characters.*;

public record IdealSettle(Map<Name, Room> idealSettle){//validation!!!
    // Room carlsonRoom = settlement.get(Name.CARLSON);
    // Room kidRoom = settlement.get(Name.KID);
    
    // if (carlsonRoom == null || kidRoom == null) {
    //     throw new IllegalArgumentException(
    //         "Carlson and Kid must be present"
    //     );
    // }
    
    // if (!carlsonRoom.equals(kidRoom)) {
    //     throw new IllegalArgumentException(
    //         String.format("Carlson must be with Kid! Carlson in %s, Kid in %s",
    //             carlsonRoom, kidRoom)
    //     )
    // }
}