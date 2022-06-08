package chess;

import chess.gameBoard.GameBoard;
import chess.gameBoard.Position;

public class Graphics {

    public static void displayBoard(GameBoard gameBoard){
        int a='A';
        for(int k=0;k<=7;k++){
            System.out.print("   "+(k+1));
        }
        System.out.println();
        for(int i=0;i<=7;i++){
            for(int j=0;j<=7;j++){
                if(j==0){
                    System.out.print((char)a+"  ");
                }
                if(gameBoard.getSquare(new Position(i,j)).isGameSquareOccupied()){
                    System.out.print(gameBoard.getSquare(new Position(i,j)).getChessPiece().toString()+"   ");
                }
                else{
                    System.out.print('-'+"   ");
                }
            }
            a++;
            System.out.println();
        }
    }
}

