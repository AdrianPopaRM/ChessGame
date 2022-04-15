package chess;

import java.util.List;
import java.util.Map;

public interface ChessPiece {
    void move();
    EntityColour getColour();
//    static Map<Integer, List<Integer>> getStartPosition(EntityColour colour);
    int getCurrentLocation();
}

