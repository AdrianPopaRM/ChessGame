package chess;

import java.util.List;
import java.util.Map;

public interface ChessPiece {
    void move();
    EntityColour getColour();
    Map<Integer, List<Integer>> getStartPosition(EntityColour colour);
}

