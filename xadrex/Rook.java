public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Position from, Position to, Piece[][] board) {
        if (from.row != to.row && from.col != to.col) return false;

        int stepRow = Integer.compare(to.row, from.row);
        int stepCol = Integer.compare(to.col, from.col);

        int row = from.row + stepRow;
        int col = from.col + stepCol;

        while (row != to.row || col != to.col) {
            if (board[row][col] != null) return false;
            row += stepRow;
            col += stepCol;
        }

        return board[to.row][to.col] == null || board[to.row][to.col].isWhite() != isWhite();
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "R" : "r";
    }
}
