package student;

public class Rook extends Figure {

    public Rook(boolean isBlack) {
		super(isBlack);
	}

	public char getSymbol() {
        return (isBlack() ? '♜' : '♖');
    }

    public String getLabel() {
        return "Turm";
    }

    @Override
    public boolean canMoveTo(Position currentPos, Position wantedPos) {
        if (currentPos == null || wantedPos == null) {
            throw new IllegalArgumentException();
        }

        boolean colChange = currentPos.getColumn() != wantedPos.getColumn();
        boolean rowChange = currentPos.getRow() != wantedPos.getRow();

        // check if both changed
        if (colChange && rowChange) {
            return false; 
        }

        // check if one changed
        if (colChange || rowChange) {
            return true;
        }

        // using false default case in this function
        return false;
    }
}
