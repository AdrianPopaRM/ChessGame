package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoardSquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class King implements ChessPiece {
    private final EntityColour colour;
    public King(EntityColour colour){
        this.colour=colour;
    }
    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return colour;
    }

    static public void initializeKingPieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
        int rowIndex = 0;
        if (colour.equals(EntityColour.WHITE)) {
            rowIndex += 7;
        }
        gameBoard[rowIndex][4].setChessPiece(new King(colour));
    }

    @Override
    public int getCurrentLocation() {
        return 0;
    }
}

