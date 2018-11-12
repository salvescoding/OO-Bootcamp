import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void perimeterShouldBeEqualToSumOfAllArms() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(rectangle.getPerimeter(), 14);
    }

    @Test
    void shouldAllowOnlyPositiveWidth() {
        Executable createARectangle = () -> new Rectangle(-1, 4);

        assertThrows(IllegalArgumentException.class, createARectangle);
    }

    @Test
    void shouldAllowOnlyPositiveHeight() {
        Executable createARectangle = () -> new Rectangle(2, -4);

        assertThrows(IllegalArgumentException.class, createARectangle);
    }

    @Test
    void shouldNotAllow0LengthWidth() {
        Executable createARectangle = () -> new Rectangle(0, 1);

        assertThrows(IllegalArgumentException.class, createARectangle);
    }

    @Test
    void shouldNotAllow0LengthHeight() {
        Executable createARectangle = () -> new Rectangle(1, 0);

        assertThrows(IllegalArgumentException.class, createARectangle);
    }

    @Test
    void areaShouldReturnWidthTimesHeight() {
        assertEquals(new Rectangle(3, 4).getArea(), 12);
        assertEquals(new Rectangle(2, 4).getArea(), 8);
    }
}