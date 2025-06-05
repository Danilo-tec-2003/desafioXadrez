public abstract class Piece {
    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public abstract boolean canMove(Position from, Position to, Piece[][] board);

    public abstract String getSymbol();
}
