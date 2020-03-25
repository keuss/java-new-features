package org.keuss.java12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Features12Test {

    @Test
    public void newSwitchTest() {
        var day = 7;
        final String attr = switch (day) {
            case 2, 3, 4, 5, 6 -> "weekday";
            case 7, 1 -> "weekend";
            default -> "invalid";
        };
        assertEquals("weekend", attr);
    }

}
