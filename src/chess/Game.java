package chess;

import chess.gameBoard.GameBoard;

public class Game {
    private GameBoard gameBoard= new GameBoard();
    public void play(){
        gameBoard.game();
    }
}
