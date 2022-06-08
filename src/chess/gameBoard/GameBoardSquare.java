package chess.gameBoard;

import chess.ChessPiece;
import chess.EntityColour;

public class GameBoardSquare {
    private final EntityColour colour;
    private ChessPiece chessPiece;

    public GameBoardSquare(EntityColour colour) {
        this.colour = colour;
    }

    public boolean isGameSquareOccupied() {
        return chessPiece != null;
    }

    public void removeChessPiece() {
        chessPiece = null;
    }

    public ChessPiece getChessPiece() {
        return this.chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public boolean hasSameChessPieceColour(GameBoardSquare gameBoardSquare) {
        if (!gameBoardSquare.isGameSquareOccupied() || !this.isGameSquareOccupied()) {
            return false;
        }
        return this.chessPiece.getColour().equals(gameBoardSquare.getChessPiece().getColour());
    }

}
