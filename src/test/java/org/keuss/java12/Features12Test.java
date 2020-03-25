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
            // it is possible to do this without a block and break
            // so default -> "invalid"; is actually enough here
            default -> "invalid";
        };
        assertEquals("weekend", attr);
    }

}
