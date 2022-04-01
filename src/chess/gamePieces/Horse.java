package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Horse implements ChessPiece {
    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return null;
    }

    @Override
    public Map<Integer, List<Integer>> getStartPosition(EntityColour colour) {
        int index=0;
        Map<Integer, List<Integer> > map=new HashMap<>();
        if(colour.equals(EntityColour.WHITE)){
            index+=7;
        }
        map.put(index,new ArrayList<>());
        map.get(index).add(1);
        map.get(index).add(6);
        return map;
    }
}
