package chess;

import chess.gameBoard.GameBoard;
import chess.gameBoard.Position;

public class Game {
    private final GameBoard gameBoard = new GameBoard();
    private final Player player1 = new Player("Adi", EntityColour.WHITE);
    private final Player player2 = new Player("Stefi", EntityColour.BLACK);

    public void play() {
        Graphics.displayBoard(gameBoard);
        int i = 0;
        while (i < 100) {
            i++;
            executeNextMove(player1);
            Graphics.displayBoard(gameBoard);
            executeNextMove(player2);
            Graphics.displayBoard(gameBoard);
        }
    }

    public void game() {

    }

    public void executeNextMove(Player player) {
        Position pieceToBeMoved = getInitialPosition(player);
        System.out.println("Number of possible moves for the chosen chess piece: "+getNumberOfPossibleMoves(pieceToBeMoved));
        Position positionToBeMovedAt = getFuturePosition(player, pieceToBeMoved);
        gameBoard.movePiece(pieceToBeMoved, positionToBeMovedAt);

    }

    private Position getFuturePosition(Player player, Position pieceToBeMovedPosition) {
        ChessPiece pieceToBeMoved = gameBoard.getSquare(pieceToBeMovedPosition).getChessPiece();
        System.out.println("Where would you like to move " + player.getName());
        Position position=null;
        do {
            if (position != null) {       //I want to move the user input part in player class at a later day
                System.out.println("The position you tried moving to was not available,try again");
            }
            position = player.getNextPosition(gameBoard);
        } while ((!pieceToBeMoved.validateMove(gameBoard, pieceToBeMovedPosition, position)));
        return position;
    }

    private Position getInitialPosition(Player player) {
        System.out.println("What piece would you like to move " + player.getName()+"?");
        Position position;
        do {
            position = player.getNextPosition(gameBoard);
        } while (!checkIfWantedInitialPositionIsAvailable(player,position));
        return position;
    }

    private boolean checkIfWantedInitialPositionIsAvailable(Player player,Position position){
        if(!isPositionOccupied(position)){
            Graphics.displayBoard(gameBoard);
            System.out.println("There is no chess piece on the wanted position, try some other: ");
            return false;
        }
        if(!positionHasChessPieceColourAsPlayer(player,position)){
            Graphics.displayBoard(gameBoard);
            System.out.println("You tried moving a piece that wasn't yours, try some other: ");
            return false;
        }
        if(getNumberOfPossibleMoves(position)==0){
            Graphics.displayBoard(gameBoard);
            System.out.println("The piece you tried moving has nowhere to go, try some other: ");
            return false;
        }
        return true;
    }
    private int getNumberOfPossibleMoves(Position chessPieceToBeMoved){
        int numberOfPossibleMoves=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(gameBoard.getSquare(chessPieceToBeMoved).getChessPiece().validateMove(gameBoard,chessPieceToBeMoved,new Position(i,j))){
                    numberOfPossibleMoves++;
                }
            }
        }
        return numberOfPossibleMoves;
    }

    private boolean positionHasChessPieceColourAsPlayer(Player player, Position position) {
//        if (gameBoard.getSquare(position).isGameSquareOccupied()) {
        return gameBoard.getSquare(position).getChessPiece().getColour().equals(player.getPlayerColour());
//        }
//        return false;
    }

    private boolean isPositionOccupied(Position position) {
        return gameBoard.getSquare(position).isGameSquareOccupied();
    }
}
