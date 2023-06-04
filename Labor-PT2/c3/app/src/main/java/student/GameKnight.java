package student;

public class GameKnight extends Knight {
    private Chessboard chessboard;

    public GameKnight(Chessboard chessboard, boolean isBlack) {
        super(isBlack);
        this.chessboard = chessboard;
    }

    @Override
    public boolean canMoveTo(Position currentPos, Position wantedPos) {
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
