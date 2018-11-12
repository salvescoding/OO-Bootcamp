import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {

    @Test
    void perimeterShouldBeEqualToSumOfAllArms() {
        assertEquals(new Square(3).getPerimeter(), 12);
        assertEquals(new Square(4).getPerimeter(), 16);
    }

    @Test
    void shouldReturnArea() {
        assertEquals(new Square(3).getArea(), 9);
        assertEquals(new Square(5).getArea(), 25);
    }

    @Test
    void shouldNotAllowASideEqualToZero() {
        assertThrows(IllegalArgumentException.class, () -> new Square(0));
    }

    @Test
    void shouldNotAllowANegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-1));
    }
}