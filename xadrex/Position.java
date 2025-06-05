public class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Position fromString(String coord) {
        if (coord.length() != 2) return null;
        int col = coord.charAt(0) - 'a';
        int row = 8 - (coord.charAt(1) - '0');
        if (row < 0 || row > 7 || col < 0 || col > 7) return null;
        return new Position(row, col);
    }
}
