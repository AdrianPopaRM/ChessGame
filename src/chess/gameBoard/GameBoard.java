package chess.gameBoard;

import chess.EntityColour;

public class GameBoard {
    private GameBoardSquare[][] gameBoard=new GameBoardSquare[8][8];


    public GameBoard(){
        initializingGameBoard();
    }
    private void initializingGameBoard(){
        EntityColour colour1= EntityColour.BLACK;
        EntityColour colour2= EntityColour.WHITE;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j+=2){
                gameBoard[i][j]=new GameBoardSquare(colour1);
                gameBoard[i][j+1]=new GameBoardSquare(colour2);
            }
            EntityColour aux= colour1;
            colour1=colour2;
            colour2=aux;
        }
    }
}
