package chess.gamePieces;

import chess.ChessPiece;
import chess.EntityColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn implements ChessPiece {
    @Override
    public void move() {

    }

    @Override
    public EntityColour getColour() {
        return null;
    }

    @Override
    public Map<Integer, List<Integer>> getStartPosition(EntityColour colour) {
        int index=1;
        Map<Integer, List<Integer> > map=new HashMap<>();

        if(getColour().equals(EntityColour.WHITE)){
            index+=5;
        }
        map.put(index,new ArrayList<>());
        for(int i=0;i<=7;i++){
            map.get(index).add(i);
        }
        return map;
    }
}
