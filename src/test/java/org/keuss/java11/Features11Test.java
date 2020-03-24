package org.keuss.java11;

import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Features11Test {

    @Test
    public void stringMethodsTest() {

        // isBlank
        assertTrue(" ".isBlank());
        assertTrue("".isBlank());
        assertFalse("foo".isBlank());

        // lines
        String str = "bar\nfoo\nbye";
        System.out.println(str.lines().collect(Collectors.toList()));
        assertEquals(3, str.lines().count());
        assertEquals("bar", str.lines().findFirst().orElseGet(() -> "nop"));

        // strip (Unicode-aware evolution of trim())
        String str2 = " keuss ";
        assertEquals("keuss", str2.strip());
        // see also stripLeading and stripTrailing

        // repeat
        assertEquals(" keuss  keuss ", str2.repeat(2));
    }

    @Test
    public void localVariableForLambdaParametersTest() {
        UnaryOperator<String> append = (@NotNull var param) -> param + " World";
        assertEquals("Hello World", append.apply("Hello"));
    }

    @Test
    public void readAndWriteStringTest() throws IOException {
        Path file = Files.createTempFile("foo", ".txt");
        System.out.println("Temp file : " + file);
        Files.writeString(file, "foo file content");
        assertEquals("foo file content", Files.readString(file));
    }

    @Test
    public void optionalIsEmptyTest() {
        // var type name in java 10
        var optional = Optional.empty();
        assertTrue(optional.isEmpty());
    }
}
