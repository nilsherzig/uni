package student;

public class Queen extends Figure {

    public Queen(boolean isBlack) {
        super(isBlack);
    }

    public char getSymbol() {
        return (getBlack() ? '♛' : '♕');
    }

    public String getLabel() {
        return "Dame";
    }

    @Override
    public boolean canMoveTo(Position startPos, Position endPos) {
        if (startPos == null || endPos == null) {
            throw new IllegalArgumentException();
        }

        int colChange = Math.abs(startPos.getColumn() - endPos.getColumn());
        int rowChange = Math.abs(startPos.getRow() - endPos.getRow());

        boolean colHasChanged = startPos.getColumn() != endPos.getColumn();
        boolean rowHasChanged = startPos.getRow() != endPos.getRow();

        if (colChange == 0 && rowChange == 0) {
            return false;
        }

        if (colHasChanged && rowHasChanged) {
            if (colChange == rowChange) {
                return true;
            }
        }

        if (colHasChanged || rowHasChanged) {
            if (colChange == 0) {
                return true;
            }

            if (rowChange == 0) {
                return true;
            }
        }

        return false;
    }
}
