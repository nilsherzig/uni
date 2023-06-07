package student; 

import java.util.HashMap; 
import java.util.Map; 

public enum LengthUnit {
    METER("m", 1),
    INCH("\"", 0.0254),
    FEET("ft", 0.3048),
    NAUTICAL_MILE("NM", 1852);

    private static final Map<String, LengthUnit> BY_SYMBOL = new HashMap<>();

    static {
        for (LengthUnit e : values()) {
            BY_SYMBOL.put(e.symbol, e);
        }
    }

    public final String symbol; 
    public final double inMeters; 

    private LengthUnit(String symbol, double value) {
        this.symbol = symbol; 
        this.inMeters = value; 
    }

	public String getSymbol() {
		return symbol;
	}

	public double getInMeters() {
		return inMeters;
	}

    @Override 
    public String toString() {
        return getSymbol();
    }

    public static LengthUnit fromSymbol(String symbol) {
        return BY_SYMBOL.get(symbol);
    }
}
