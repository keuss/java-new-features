package org.keuss.java10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class Features10Test {

    @Test
    public void localVariableTypeInferenceTest() {
        // see https://www.baeldung.com/java-10-local-variable-type-inference
        var message = "Hello, Java 10";
        assertTrue(message instanceof String);

        var map = new HashMap<Integer, String>();
        assertTrue(map instanceof HashMap);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiableCollectionsTest() {
        // see https://www.baeldung.com/java-10-overview
        var list = new ArrayList<Integer>();
        List.copyOf(list).add(1);

        List<Integer> evenList = list.stream()
                .filter(i -> i >= 1)
                .collect(Collectors.toUnmodifiableList());
        evenList.add(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void optionalOrElseThrowTest() {
        List.of(0, 1).stream()
                .filter(i -> i > 1)
                .findFirst()
                .orElseThrow();
    }
}
