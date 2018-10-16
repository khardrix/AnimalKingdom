package com.github.khardrix.AnimalKingdom;

// IMPORTS of needed tools and plug-ins.
import java.awt.*;


public class WhiteTiger extends Critter{

    private boolean isChild = true;
    private int moveCount;


    public WhiteTiger(){

        /*
            WhiteTiger: This should behave just like a Tiger except that they will be White.
            They will also be lower-case until they infect another Critter, then they "grow up".
         */
    }


    public Color getColor(){

        /*
            Always Color.WHITE.
         */

        return Color.WHITE;
    }


    public String toString(){

        /*
            "tgr" if it hasn't infected another Critter yet, “TGR” if it has infected.
         */

        while(isChild){
            return "tgr";
        }
        return "TGR";
    }


    public Action getMove(CritterInfo info){

        /*
            Always infect if an enemy is in front,
            otherwise if a wall is in front or to the right, then turn left,
            otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
         */

        moveCount++;
        if(info.getFront() == Neighbor.OTHER) {
            isChild = false;
            return Action.INFECT;
        }
        else if((info.getFront() == Neighbor.WALL) || (info.getRight() == Neighbor.WALL))
            return Action.LEFT;
        else if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }
}
