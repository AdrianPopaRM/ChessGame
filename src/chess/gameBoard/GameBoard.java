package chess.gameBoard;

import chess.ChessPiece;
import chess.EntityColour;
import chess.gamePieces.Bishop;
import chess.gamePieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private final GameBoardSquare[][] gameBoard = new GameBoardSquare[8][8];
    private final List<ChessPiece> eliminatedWhitePieces = new ArrayList<>();
    private final List<ChessPiece> eliminatedBlackPieces = new ArrayList<>();

    public GameBoard() {
        initializingGameBoard();
    }

    public GameBoardSquare getSquare(Position position) {
        return gameBoard[position.getRow()][position.getCol()];
    }

    private void initializingGameBoard() {
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 8; columnIndex++) {
                initializingGameBoardSquare(rowIndex, columnIndex);
            }
        }
        this.initializingGamePieces();
    }

    private void initializingGameBoardSquare(int rowIndex, int columnIndex) {
        if ((rowIndex + columnIndex) % 2 == 0) {
            gameBoard[rowIndex][columnIndex] = new GameBoardSquare(EntityColour.WHITE);
        } else {
            gameBoard[rowIndex][columnIndex] = new GameBoardSquare(EntityColour.BLACK);
        }
    }

    public void movePiece(Position chessPiece, Position futureSquarePosition) {
        GameBoardSquare currentSquare = getSquare(chessPiece);
        GameBoardSquare futureSquare = getSquare(futureSquarePosition);
        if (futureSquare.isGameSquareOccupied()) {

            if (futureSquare.getChessPiece().getColour().equals(EntityColour.WHITE)) {
                eliminatedWhitePieces.add(futureSquare.getChessPiece());
            } else {
                eliminatedBlackPieces.add(futureSquare.getChessPiece());
            }
            futureSquare.removeChessPiece();
        }
        futureSquare.setChessPiece(currentSquare.getChessPiece());
        currentSquare.removeChessPiece();
    }

    private void initializingGamePieces() {
        for (EntityColour colour : EntityColour.values()) {
//            Queen.initializeQueenPieces(colour, this.gameBoard);
//            King.initializeKingPieces(colour, this.gameBoard);
//            Rook.initializeRookPieces(colour, this.gameBoard);
//            Horse.initializeHorsePieces(colour, this.gameBoard);
            Bishop.initializeBishopPieces(colour, this.gameBoard);
            Pawn.initializePawnPieces(colour, this.gameBoard);
        }
    }

//    boolean moveIsOnBoard(int moveRowIndex, int moveColumnIndex) {
//        return (moveRowIndex <= 7 && moveColumnIndex <= 7) && (moveRowIndex >= 0 && moveColumnIndex >= 0);
//    }
//    I dont know if i need this anymore

}
