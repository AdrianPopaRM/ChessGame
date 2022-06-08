package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoard;
import chess.gameBoard.GameBoardSquare;
import chess.gameBoard.Position;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn implements ChessPiece {
    private final EntityColour colour;

    public Pawn(EntityColour colour) {
        this.colour = colour;
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
    public boolean validateMove(GameBoard gameBoard, Position currentPosition, Position futurePosition) {
        EntityColour colourOfPieceUWantToMove = gameBoard.getSquare(currentPosition).getChessPiece().getColour();

        int currentPositionRow = currentPosition.getRow();
        int currentPositionCol = currentPosition.getCol();

        int futurePositionRow = futurePosition.getRow();
        int futurePositionCol = futurePosition.getCol();

        int distanceRow=futurePositionRow - currentPositionRow;
        if(colourOfPieceUWantToMove.equals(EntityColour.WHITE)){
            distanceRow*=-1; //For white the board is "inverted"
        }
        int distanceCol=Math.abs(futurePositionCol - currentPositionCol);

        if(distanceRow<1){
            return false;
        }
        if(isPawnTryingToMoveForward(gameBoard,currentPosition,futurePosition,distanceRow,distanceCol)){
            return true;
        }
        return isPawnTryingToMoveSideways(gameBoard,currentPosition,futurePosition,distanceRow,distanceCol);

    }

    private boolean isPawnTryingToMoveForward(GameBoard gameBoard, Position currentPosition, Position futurePosition, int distanceRow, int distanceCol) {
        if (distanceCol == 0) {
            if(distanceRow>2){
                return false;
            }
            if (distanceRow == 2 && !isPawnOnInitialPositionAndPathClear(gameBoard, currentPosition)) {
                return false;
            }
            return !gameBoard.getSquare(futurePosition).isGameSquareOccupied();
        }
        return false;
    }

    private boolean isPawnTryingToMoveSideways(GameBoard gameBoard, Position currentPosition, Position futurePosition, int distanceRow, int distanceCol) {
        GameBoardSquare futureSquare=gameBoard.getSquare(futurePosition);
        GameBoardSquare currentSquare=gameBoard.getSquare(currentPosition);

        if(distanceRow==1&&distanceCol==1){
            return futureSquare.isGameSquareOccupied()&&!futureSquare.hasSameChessPieceColour(currentSquare);
        }
        return false;
    }

    private boolean isPawnOnInitialPositionAndPathClear(GameBoard gameBoard, Position pieceToVerify) {
        EntityColour colourOfPieceUWantToMove = gameBoard.getSquare(pieceToVerify).getChessPiece().getColour();
        int nextSquareRow=0;
        int pieceToVerifyRow = pieceToVerify.getRow();
        if(colourOfPieceUWantToMove.equals(EntityColour.WHITE)&&pieceToVerifyRow==6){
             nextSquareRow=5;
        }
        if(colourOfPieceUWantToMove.equals(EntityColour.BLACK)&&pieceToVerifyRow==1) {
            nextSquareRow = 2;
        }
        return !gameBoard.getSquare(new Position(nextSquareRow, pieceToVerify.getCol())).isGameSquareOccupied();
    }

    @Override
    public String toString() {
        return "P";
    }
}
