package student;

public class Figure {
    private boolean black;

    public Figure(boolean isBlack) {
        this.black = isBlack;
    }

    public boolean canMoveTo(Position currentPos, Position wantedPos) {
        if (currentPos == null || wantedPos == null) {
            throw new IllegalArgumentException();
        }

        if (currentPos.equals(wantedPos)) {
            return false;
        }
        return true;
    }

    public char getSymbol() {
        return '?'; // will be overwritten by subclasses
    }

    public String getLabel() {
        return "Unbekannte Figur"; // will be overwritten by subclasses
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLabel());
        sb.append(" (");
        sb.append(isBlack() ? "schwarz" : "weiß");
        sb.append(")");
        return sb.toString();
    }

}
