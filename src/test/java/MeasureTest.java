import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeasureTest {
    @DisplayName("Should be equal when there is the same volume between")
    @Nested
    class ShouldBeEqual {

        @Test
        void gallonsAndLiters() {
            Measure measure1 = new Measure(1, Unit.GALLONS);
            Measure measure2 = new Measure(3.7854, Unit.LITERS);

            assertThat(measure1, is(measure2));
        }
    }

    @DisplayName("Should not be equal when the volume is different between")
    @Nested
    class ShouldNotBeEqual {

        @Test
        void gallonsAndLiters() {
            Measure measure1 = new Measure(5, Unit.GALLONS);
            Measure measure2 = new Measure(2, Unit.LITERS);

            assertThat(measure1, not(measure2));
        }
    }

    @Test
    void shouldAdd() {
        assertThat(new Measure(41.37008, Unit.INCHES),
                is(new Measure(2, Unit.INCHES).add(new Measure(1, Unit.METERS))));
    }

    @Test
    void shouldNotSumMetersAndLiters() {
        Measure liters = new Measure(4, Unit.LITERS);
        Measure meters = new Measure(4, Unit.METERS);

        assertThrows(IllegalArgumentException.class, () -> liters.add(meters));

    }
}