import java.util.Objects;

public class Chance {

    private static final double DELTA = 0.00000000001;
    private final double probability;
    private static final double TOTAL_PROBABILITY = 1.0;

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance ofNotHappen() {
        return new Chance(TOTAL_PROBABILITY - probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance that = (Chance) o;
        return that.probability - this.probability < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }
}
