package pl.Lukaszmaguda.creditcard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class AssertjTest {

    @Test
    void helloAssertJ() {
        var hello = "Hello World";

        //assertThat(hello).containsOnlyDigits();
    }

    @Test
    void testSomeListExpression() {
        var names = Collections.singleton("Łukasz");

        //assertThat(names)
                //.isUnmodifiable()
                //.hasSize(3)
                //.containsAll(Arrays.asList("Łukasz", "Artur"));
    }
}
