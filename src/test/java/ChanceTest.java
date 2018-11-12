import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {

    @Test
    void shouldReturnChanceOfNotANumber(){
        Chance chance = new Chance(0.7);
        assertEquals(chance.ofNotHappen(), new Chance(0.3));
    }
}
