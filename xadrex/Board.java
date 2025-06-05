public class Board {
    private Piece[][] grid = new Piece[8][8];

    public Board() {
        setup();
    }

    public void setup() {
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn(false);
            grid[6][i] = new Pawn(true);
        }

        grid[0][0] = new Rook(false);
        grid[0][7] = new Rook(false);
        grid[7][0] = new Rook(true);
        grid[7][7] = new Rook(true);
    }

    public boolean move(Position from, Position to, boolean isWhiteTurn) {
        Piece piece = grid[from.row][from.col];
        if (piece == null || piece.isWhite() != isWhiteTurn) return false;

        if (piece.canMove(from, to, grid)) {
            grid[to.row][to.col] = piece;
            grid[from.row][from.col] = null;
            return true;
        }

        return false;
    }

    public void print() {
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " ");
            for (int col = 0; col < 8; col++) {
                Piece piece = grid[row][col];
                System.out.print((piece == null ? "." : piece.getSymbol()) + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
