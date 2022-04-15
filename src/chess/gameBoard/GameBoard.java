package chess.gameBoard;

import chess.EntityColour;
import chess.gamePieces.*;

import java.util.Arrays;

public class GameBoard {
    private GameBoardSquare[][] gameBoard=new GameBoardSquare[8][8];


    public GameBoard(){
    }

    public void game(){
        initializingGameBoard();
    }
    private void initializingGameBoard(){
        for(int rowIndex=0;rowIndex<8;rowIndex++) {
            for (int columnIndex = 0; columnIndex < 8; columnIndex++) {
                initializingGameBoardSquare(rowIndex, columnIndex);
            }
        }
        this.initializingGamePieces();
    }

    private void initializingGameBoardSquare(int rowIndex,int columnIndex){
        if((rowIndex+columnIndex)%2==0){
            gameBoard[rowIndex][columnIndex]=new GameBoardSquare(EntityColour.WHITE);
        }
        else{
            gameBoard[rowIndex][columnIndex]=new GameBoardSquare(EntityColour.BLACK);
        }
    }

    private void initializingGamePieces(){
        for(EntityColour colour: EntityColour.values()){
            Queen.initializeQueenPieces(colour,this.gameBoard);
            King.initializeKingPieces(colour,this.gameBoard);
            Rook.initializeRookPieces(colour,this.gameBoard);
            Horse.initializeHorsePieces(colour,this.gameBoard);
            Bishop.initializeBishopPieces(colour,this.gameBoard);
            Pawn.initializePawnPieces(colour,this.gameBoard);
        }
    }
}
