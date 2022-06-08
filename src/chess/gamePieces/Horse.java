//package chess.gamePieces;
//
//import chess.ChessPiece;
//import chess.EntityColour;
//import chess.gameBoard.GameBoard;
//import chess.gameBoard.GameBoardSquare;
//import chess.gameBoard.Position;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Horse implements ChessPiece {
//    private int rowIndex;
//    private int columnIndex;
//    private final EntityColour colour;
//
//    public Horse(EntityColour colour,int rowIndex, int columnIndex) {
//        this.colour = colour;
//        this.rowIndex=rowIndex;
//        this.columnIndex=columnIndex;
//    }
//
//    @Override
//    public void move() {
//
//    }
//
//    @Override
//    public EntityColour getColour() {
//        return null;
//    }
//
//    static public void initializeHorsePieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
//        int rowIndex = 0;
//        if (colour.equals(EntityColour.WHITE)) {
//            rowIndex += 7;
//        }
//        gameBoard[rowIndex][1].setChessPiece(new Horse(colour,rowIndex,1));
//        gameBoard[rowIndex][6].setChessPiece(new Horse(colour,rowIndex,6));
//    }
//
//    public boolean validateMove(GameBoard gameBoard, Position currentPosition, Position futurePosition){
//        return false;
//    }
//    @Override
//    public int getCurrentLocation() {
//        return 0;
//    }
//}
