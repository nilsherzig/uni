package student;

public class Pawn extends Figure {

    public Pawn(boolean isBlack) {
		super(isBlack);
	}

	public char getSymbol() {
        return (isBlack() ? '♟' : '♙');
    }

    public String getLabel() {
        return "Bauer";
    }

    @Override
    public boolean canMoveTo(Position currentPos, Position wantedPos) {
        if (currentPos == null || wantedPos == null) {
            throw new IllegalArgumentException();
        }

        if (currentPos.getColumn() != wantedPos.getColumn()) {
            return false;
        }

        if (isBlack()) {
            // check if moves down
            if (currentPos.getRow() >= wantedPos.getRow()) {
                return false;
            }

            // allow 2 moves from start pos
            if (currentPos.getRow() == 1 && wantedPos.getRow() - 2 == currentPos.getRow()) {
                return true;
            }

            // allow 1 move
            if (wantedPos.getRow() - 1 == currentPos.getRow()) {
                return true;
            }

        } else {
            // check if moves up
            if (currentPos.getRow() <= wantedPos.getRow()) {
                return false;
            }

            // allow 2 moves down form start pos
            if (currentPos.getRow() == 6 && wantedPos.getRow() + 2 == currentPos.getRow()) {
                return true;
            }

            // allow 1 move down
            if (wantedPos.getRow() + 1 == currentPos.getRow()) {
                return true;
            }
        }

        return true;
    }
}
