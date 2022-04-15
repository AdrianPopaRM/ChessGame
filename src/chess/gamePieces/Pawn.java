package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoardSquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn implements ChessPiece {
    private final EntityColour colour;

    public Pawn(EntityColour colour){
        this.colour=colour;
    }
    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return colour;
    }

    static public void initializePawnPieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
        int rowIndex = 1;
        if (colour.equals(EntityColour.WHITE)) {
            rowIndex += 5;
        }
        for (int i = 0; i < 8; i++) {
            gameBoard[rowIndex][i].setChessPiece(new Pawn(colour));
        }
    }

    @Override
    public int getCurrentLocation() {
        return 0;
    }
}
