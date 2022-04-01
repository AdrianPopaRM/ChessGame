package chess.gameBoard;

import chess.EntityColour;

public class GameBoardSquare {
    private boolean isOccupied;
    private final EntityColour colour;

    public GameBoardSquare(EntityColour colour){
        isOccupied=false;
        this.colour=colour;
    }
}
