package chess.gameBoard;

public class Position {
    private int row, col;

    public Position(int lin, int col) {
        this.row = lin;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
