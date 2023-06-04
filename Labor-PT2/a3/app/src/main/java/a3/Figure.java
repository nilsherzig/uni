package a3;

public abstract class Figure {
    private boolean black;

    public boolean canMoveTo(Position currentPos, Position wantedPos) {
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
        sb.append(isBlack() ? "black" : "white");
        sb.append(")");
        return sb.toString();
    }

}
