package student;

public class GameRook extends Rook {
    private Chessboard chessboard;

    public GameRook(Chessboard chessboard, boolean isBlack) {
        super(isBlack);
        this.chessboard = chessboard;
    }

    @Override
    public boolean canMoveTo(Position currentPos, Position wantedPos) {
        // check way
        if (!this.chessboard.isFreeBetween(currentPos, wantedPos)) {
            return false;
        }

        // check wantedPos color
        if (this.chessboard.getFigure(wantedPos) != null) {
            if (this.chessboard.getFigure(wantedPos).getBlack() == this.getBlack()) {
                System.out.println("you can't attack the same color");
                return false;
            }
        }

        return true;
    }
}
