package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoardSquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Horse implements ChessPiece {
    private final EntityColour colour;

    public Horse(EntityColour colour) {
        this.colour = colour;
    }

    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return null;
    }

    static public void initializeHorsePieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
        int rowIndex = 0;
        if (colour.equals(EntityColour.WHITE)) {
            rowIndex += 7;
        }
        gameBoard[rowIndex][1].setChessPiece(new Horse(colour));
        gameBoard[rowIndex][6].setChessPiece(new Horse(colour));
    }

    @Override
    public int getCurrentLocation() {
        return 0;
    }
}
