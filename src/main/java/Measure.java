import java.util.Objects;

public class Measure {
    public static final double DELTA = 0.0001;
    private final double value;
    private final Unit unit;

    public Measure(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure that = (Measure) o;
        return (Math.abs(that.unit.convertToBaseUnit(that.value) - this.unit.convertToBaseUnit(this.value)) < DELTA)
                && that.unit.hasCommonBaseUnit(this.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Measure add(Measure measure) {
        validate(measure);

        double sum = measure.unit.convertToBaseUnit(measure.value) +
                this.unit.convertToBaseUnit(this.value);

        return new Measure(unit.fromBase(sum), unit);
    }

    private void validate(Measure measure) {
        if (!this.unit.hasCommonBaseUnit(measure.unit)) throw new IllegalArgumentException();
    }

    //TODO move convert to unit login in Unit class
}