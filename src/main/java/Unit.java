public class Unit {
    public final static Unit METERS = new Unit();
    public final static Unit FEET = new Unit(0.3048, Unit.METERS);
    public final static Unit INCHES = new Unit(0.0254, Unit.METERS);
    public final static Unit YARDS = new Unit(0.9144, Unit.METERS);
    public final static Unit CENTIMETERS = new Unit(0.01, Unit.METERS);
    public final static Unit GALLONS = new Unit();
    public final static Unit LITERS = new Unit(3.7854, Unit.GALLONS);


    private final double baseRate;
    private final Unit baseUnit;

    Unit(double baseRate, Unit baseUnit) {
        this.baseRate = baseRate;
        this.baseUnit = baseUnit;
    }

    Unit() {
        this.baseRate = 1;
        this.baseUnit = this;
    }

    public double convertToBaseUnit(double amount) {
        return amount * baseRate;
    }

    public boolean hasCommonBaseUnit(Unit unit) {
        return baseUnit.equals(unit.baseUnit);
    }

    public double fromBase(double sum) {
        return sum/baseRate;
    }

    public double toUnit(double value, Unit unit) {
        return value * unit.baseRate / baseRate;
    }
}