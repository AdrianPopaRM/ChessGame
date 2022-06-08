package chess;

import chess.gameBoard.GameBoard;
import chess.gameBoard.Position;

import java.util.Locale;
import java.util.Scanner;

public class Player {
    private String name;
    private EntityColour playerColour;
    public Player(String name,EntityColour colour){
        this.name=name;
        this.playerColour=colour;
    }

    public EntityColour getPlayerColour() {
        return playerColour;
    }

    public Position getNextPosition(GameBoard gameBoard){
        Scanner keyboard = new Scanner(System.in);
        String input="";
        int rowIndex=-1;
        int colIndex=-1;
        while((input.length()!=2)||((rowIndex<0||rowIndex>=8)||(colIndex<0||colIndex>=8))){
            if(!input.equals("")){
                System.out.println("Input does not respect the format, try again:");
            }
            input =keyboard.next();
            input=input.toLowerCase(Locale.ROOT);
            rowIndex= input.charAt(0)-'a';
            colIndex= Integer.parseInt(String.valueOf(input.charAt(1)))-1;
        }
        return new Position(rowIndex,colIndex);
    }
    public String getName() {
        return name;
    }
}
