public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Position from, Position to, Piece[][] board) {
        int dir = isWhite() ? -1 : 1;
        return from.col == to.col && to.row == from.row + dir && board[to.row][to.col] == null;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "P" : "p";
    }
}
