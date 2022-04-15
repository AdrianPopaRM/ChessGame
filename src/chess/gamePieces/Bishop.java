package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoardSquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop implements ChessPiece {
    private int currentPosition;// In rowColumn format; Ex: 06,47,28
    private final EntityColour colour;
    public Bishop(EntityColour colour){
        this.colour=colour;
    }
    public void updateCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return null;
    }

    static public void initializeBishopPieces(EntityColour colour,GameBoardSquare[][] gameBoard) {
        int rowIndex = 0;
            if (colour.equals(EntityColour.WHITE)) {
            rowIndex += 7;
        }
            gameBoard[rowIndex][2].setChessPiece(new Bishop(colour));
            gameBoard[rowIndex][5].setChessPiece(new Bishop(colour));
    }
    @Override
    public int getCurrentLocation() {
        return 0;
    }
}
