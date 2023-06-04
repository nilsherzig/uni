package student;

public class Bishop extends Figure {

    public Bishop(boolean isBlack) {
        super(isBlack);
    }

    public char getSymbol() {
        return (getBlack() ? '♝' : '♗');
    }

    public String getLabel() {
        return "Läufer";
    }

    @Override
    public boolean canMoveTo(Position startPos, Position endPos) {
        if (startPos == null || endPos == null) {
            throw new IllegalArgumentException();
        }

        int colChange = Math.abs(startPos.getColumn() - endPos.getColumn());
        int rowChange = Math.abs(startPos.getRow() - endPos.getRow());

        if (colChange == 0 || rowChange == 0) {
            return false;
        }

        return colChange == rowChange;
    }
}
