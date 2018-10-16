package com.github.khardrix.AnimalKingdom;

// IMPORTS of needed tools and plug-ins.
import java.awt.*;
import java.util.Random;

public class Tiger extends Critter{

    private Random dice = new Random();
    private int moveCount = 0;
    private Color color;
    private int randomNumber;



    public Tiger(){

        this.color = getColor();
    }


    public Color getColor(){

        /*
            Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
            and uses that color for three moves, then randomly picks one of those colors again
            for the next three moves, then randomly picks another one of those colors
            for the next three moves, and so on.
         */


        randomNumber = dice.nextInt(3);
        if(randomNumber == 0)
            return Color.RED;
        else if(randomNumber == 1)
            return Color.GREEN;
        else
            return Color.BLUE;
    }


    public String toString(){

        /*
            "TGR"
         */

        return "TGR";
    }


    public Action getMove(CritterInfo info){

        /*
            always infect if an enemy is in front,
            otherwise if a wall is in front or to the right, then turn left,
            otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
         */

        moveCount++;
        if(moveCount % 3 == 0) {
            this.color = getColor();
            moveCount = 0;
        }

        if(info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if((info.getFront() == Neighbor.WALL) || (info.getRight() == Neighbor.WALL))
            return Action.LEFT;
        else if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }
}
