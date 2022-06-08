package chess;

import chess.gameBoard.GameBoard;
import chess.gameBoard.GameBoardSquare;
import chess.gameBoard.Position;

import java.util.List;
import java.util.Map;

public interface ChessPiece {
    EntityColour getColour();
//    static Map<Integer, List<Integer>> getStartPosition(EntityColour colour);
    boolean validateMove(GameBoard gameBoard, Position currentPosition, Position futurePosition);
}

