package pl.Lukaszmaguda.hello;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class HelloTest {
    @Test
    void helloTest() {
        //A / Arrange  / Given
        var a = 2;
        var b = 4;
        //A / Act      / When
        var result = a + b;
        //A / Assert   / Then / Expected
        assert 6 == result;
    }

    @Test
    void itFail() {
        //A / Arrange  / Given
        var a = 2;
        var b = 4;
        //A / Act      / When
        var result = a + b;
        //A / Assert   / Then / Expected
        assert 10 == result;
    }

    @Test
    void itGreetUsername() {
        //Arrange
        String name = "Łukasz";
        //Act
        String message = String.format("Hello %s", name);
        //Assert
        assertEquals("Hello Łukasz", message);
    }

    @Test
    void listExpectedToBeEmpty() {
        var list = new ArrayList<>();

        list.add("Łukasz");
        list.remove(0);

        assert list.isEmpty();
    }
}
