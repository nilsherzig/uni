package student;

import java.util.HashMap;
import java.util.Map;

public enum AtmosphericLayer {
    TROPO("Troposphäre", "Troposphere", new Length(0)),
    STRATO("Stratosphäre", "Stratosphere", new Length(15000)),
    MESO("Mesosphäre", "Mesosphere", new Length(50000)),
    THERMO("Thermosphäre", "Thermosphere", new Length(80000)),
    EXO("Exosphäre", "Exosphere", new Length(500000));

    public final String german;
    public final String english;
    public final Length startAltitude;

    private AtmosphericLayer(String german, String english, Length startAltitude) {
        this.german = german;
        this.english = english;
        this.startAltitude = startAltitude;
    }

    public String getGerman() {
		return german;
	}

	public String getEnglish() {
		return english;
	}

	public Length getStartAltitude() {
		return startAltitude;
	}

	@Override
    public String toString() {
        return String.format("%s über %d m", getGerman(), getStartAltitude());
    }
}
