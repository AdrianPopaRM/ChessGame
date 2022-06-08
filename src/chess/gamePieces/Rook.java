//package chess.gamePieces;
//
//import chess.ChessPiece;
//import chess.EntityColour;
//import chess.gameBoard.GameBoardSquare;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Rook implements ChessPiece {
//    private int rowIndex;
//    private int columnIndex;
//    private final EntityColour colour;
//
//    public Rook(EntityColour colour,int rowIndex, int columnIndex){
//        this.colour=colour;
//        this.rowIndex=rowIndex;
//        this.columnIndex=columnIndex;
//    }
//    @Override
//    public void move() {
//    }
//
//    @Override
//    public EntityColour getColour() {
//        return colour;
//    }
//
//    static public void initializeRookPieces(EntityColour colour, GameBoardSquare[][] gameBoard) {
//        int rowIndex = 0;
//        if (colour.equals(EntityColour.WHITE)) {
//            rowIndex += 7;
//        }
//        gameBoard[rowIndex][0].setChessPiece(new Rook(colour,rowIndex,0));
//        gameBoard[rowIndex][7].setChessPiece(new Rook(colour,rowIndex,7));
//    }
//
//    @Override
//    public int getCurrentLocation() {
//        return 0;
//    }
//}
