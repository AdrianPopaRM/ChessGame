package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gameBoard.GameBoard;
import chess.gameBoard.GameBoardSquare;
import chess.gameBoard.Position;

public class Bishop implements ChessPiece {

    private final EntityColour colour;

    public Bishop(EntityColour colour) {
        this.colour = colour;
    }

    @Override
    public EntityColour getColour() {
        return colour;
    }

    static public void initializeBishopPieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
        int rowIndex = 0;
        if (colour.equals(EntityColour.WHITE)) {
            rowIndex += 7;
        }
        gameBoard[rowIndex][2].setChessPiece(new Bishop(colour));
        gameBoard[rowIndex][5].setChessPiece(new Bishop(colour));
    }
    
    @Override
    public boolean validateMove(GameBoard gameBoard, Position currentPosition, Position futurePosition) {
        GameBoardSquare futureSquare = gameBoard.getSquare(futurePosition);
        GameBoardSquare currentSquare = gameBoard.getSquare(currentPosition);

        if (!isValidMoveOnDiagonal(currentPosition, futurePosition, gameBoard)) {
            return false;
        }
        if (!futureSquare.isGameSquareOccupied()) {
            return true;
        }
        return !futureSquare.hasSameChessPieceColour(currentSquare);
    }

    private boolean isValidMoveOnDiagonal(Position currentPosition, Position futurePosition, GameBoard gameBoard) {

        int futurePositionRow = futurePosition.getRow();
        int currentPositionRow = currentPosition.getRow();
        int currentPositionCol = currentPosition.getCol();
        int futurePositionCol = futurePosition.getCol();

        if (Math.abs(futurePositionRow - currentPositionRow) == Math.abs(futurePositionCol - currentPositionCol)) { //Checks if the move is located on the diagonal
            int auxRowIndex = currentPositionRow;
            int auxColumnIndex = currentPositionCol;

            while (auxRowIndex != futurePositionRow && auxColumnIndex != futurePositionCol) {  //Loop checks if the diagonal is clear
                if (auxRowIndex < futurePositionRow) {
                    auxRowIndex++;
                } else {
                    auxRowIndex--;
                }
                if (auxColumnIndex < futurePositionCol) {
                    auxColumnIndex++;
                } else {
                    auxColumnIndex--;
                }
                // The code above is for moving through the diagonal
                if (gameBoard.getSquare(new Position(auxRowIndex, auxColumnIndex)).isGameSquareOccupied()) {
                    if(auxRowIndex!=futurePositionRow && auxColumnIndex!=futurePositionCol)
                        return false;
                }
            }
            return true;    //If it exited the loop it means the diagonal is clear, and the move is possible
        }
        return false;   //If it gets here it means the move wasn't located on a diagonal
    }

    @Override
    public String toString() {
        return "B";
    }
}
