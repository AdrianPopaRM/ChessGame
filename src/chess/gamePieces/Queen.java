//package chess.gamePieces;
//
//import chess.ChessPiece;
//import chess.EntityColour;
//import chess.gameBoard.GameBoard;
//import chess.gameBoard.GameBoardSquare;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Queen implements ChessPiece {
//    private final EntityColour colour;
//    private int rowIndex;
//    private int columnIndex;
//
//    public Queen(EntityColour colour,int rowIndex, int columnIndex){
//        this.colour=colour;
//        this.rowIndex=rowIndex;
//        this.columnIndex=columnIndex;
//    }
//    @Override
//    public void move() {
//
//    }
//    @Override
//    public EntityColour getColour() {
//        return colour;
//    }
//
//    static public void initializeQueenPieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
//        int rowIndex = 0;
//        if (colour.equals(EntityColour.WHITE)) {
//            rowIndex += 7;
//        }
//        gameBoard[rowIndex][3].setChessPiece(new Queen(colour,rowIndex,3));
//    }
//
//    @Override
//    public int getCurrentLocation() {
//        return 0;
//    }
//}
