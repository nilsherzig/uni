package student;

public class Knight extends Figure {

    public Knight(boolean isBlack) {
		super(isBlack);
	}

	public char getSymbol() {
        return (isBlack() ? '♞' : '♘');
    }

    public String getLabel() {
        return "Springer";
    }

    @Override
    public boolean canMoveTo(Position currentPos, Position wantedPos) {
        if (currentPos == null || wantedPos == null) {
            throw new IllegalArgumentException();
        }

        int colChange = Math.abs(currentPos.getColumn() - wantedPos.getColumn());
        int rowChange = Math.abs(currentPos.getRow() - wantedPos.getRow());

        if (colChange == 1 && rowChange == 2) {
            return true;
        }

        if (colChange == 2 && rowChange == 1) {
            return true;
        }

        return false;
    }
}
