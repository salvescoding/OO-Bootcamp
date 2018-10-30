import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    void greetsTheWorld() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals("Hola!", helloWorld.greet());
    }

    @Test
    void createsCollectionOfPositiveIntegers() {
        HelloWorld helloWorld = new HelloWorld();

        assertThat(helloWorld.positiveIntegers(), everyItem(greaterThan(0)));
    }
}
