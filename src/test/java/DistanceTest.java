import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class DistanceTest {

    @DisplayName("Should be equal when there is the same length between")
    @Nested
    class ShouldBeEqual {

        @Test
        void feetAndMeters() {
            Measure distance1 = new Measure(5, Unit.FEET);
            Measure distance2 = new Measure(1.524, Unit.METERS);

            assertThat(distance1, is(distance2));
        }
        @Test
        void inchesAndYards() {
            Measure distance1 = new Measure(5, Unit.INCHES);
            Measure distance2 = new Measure(0.1389, Unit.YARDS);

            assertThat(distance1, is(distance2));
        }

        @Test
        void metersAndCentimeters() {
            Measure distance1 = new Measure(2, Unit.METERS);
            Measure distance2 = new Measure(200, Unit.CENTIMETERS);

            assertThat(distance1, is(distance2));
        }

    }
    @DisplayName("Should not be equal when the length is different between")
    @Nested
    class ShouldNotBeEqual {

        @Test
        void feetAndMeter() {
            Measure distance1 = new Measure(5, Unit.FEET);
            Measure distance2 = new Measure(2, Unit.METERS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void inchesAndYards() {
            Measure distance1 = new Measure(5, Unit.INCHES);
            Measure distance2 = new Measure(2, Unit.YARDS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void metersAndCentimeters() {
            Measure distance1 = new Measure(2, Unit.METERS);
            Measure distance2 = new Measure(100, Unit.CENTIMETERS);

            assertThat(distance1, not(distance2));
        }

    }

}