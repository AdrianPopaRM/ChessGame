package chess.gameBoard;

import chess.ChessPiece;
import chess.EntityColour;

public class GameBoardSquare {
    private boolean isOccupied;
    private final EntityColour colour;
    private ChessPiece chessPiece;

    public GameBoardSquare(EntityColour colour) {
        isOccupied = false;
        this.colour = colour;
    }

    public ChessPiece getChessPiece() {
            return this.chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        isOccupied=true;
    }
}
