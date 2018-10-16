package com.github.khardrix.AnimalKingdom;

// IMPORTS of needed tools and plug-ins.
import java.awt.*;
import java.util.Random;

public class Bear extends Critter{

    Random dice = new Random();
    private int number;
    private int moveCount = 0;
    private Color color;
    private boolean polar;


    public Bear(){

        this.polar = isPolar();
        this.color = getColor();
    }


    public boolean isPolar(){

        number = dice.nextInt(2);
        if(number == 1)
            return true;
        else
            return false;
    }


    public Color getColor(){

        /*
            Color.WHITE for a polar bear (when polar is true),
            Color.BLACK otherwise (when polar is false)
         */

        if(polar){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }


    public String toString(){

        /*
            Should alternate on each different move between a slash character (/)
            and a backslash character (\) starting with a slash.
         */

        if(moveCount % 2 == 0){
            return "/";
        }else{
            return "\\";
        }
    }


    public Action getMove(CritterInfo info){

        /*
            always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
         */

        moveCount++;

        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return super.getMove(info);
        }
    }
}
