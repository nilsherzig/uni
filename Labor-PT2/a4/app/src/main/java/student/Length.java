package student;

public class Length implements Comparable<Length> {

    private double value;
    private LengthUnit unit;

    public Length() {
        this.value = 0;
        this.unit = LengthUnit.METER;
    }

    public Length(double value) {
        this.value = value;
        this.unit = LengthUnit.METER;
    }

    public Length(LengthUnit lengthUnit, double value) {
        if (lengthUnit == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = lengthUnit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public void setUnit(LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        }
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("%.4f %s", getValue(), getUnit().toString());
    }

    public double getValueIn(LengthUnit wantedUnit) {
        if (wantedUnit == null) {
            throw new IllegalArgumentException();
        }
        return (this.value * this.unit.getInMeters()) / wantedUnit.getInMeters();
    }

    @Override
    public int compareTo(Length o) {
        double foo = this.getValueIn(LengthUnit.METER);
        double compareValue = o.getValueIn(LengthUnit.METER);

        if (foo > compareValue) {
            return 1;
        }
        if (foo < compareValue) {
            return -1;
        }
        return 0;
    }

    // @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if(other instanceof Length ol) {

            return this.getValueIn(LengthUnit.METER) == ol.getValueIn(LengthUnit.METER);
        }

        return false;
    }
}
