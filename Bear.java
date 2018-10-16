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

        /*
            Bear: Try running the simulator with just 30 bears in the world.
            You should see about half of them being white and about half being black.
            Initially they should all be displayed with slash characters.
            When you click "step", they should all switch to backslash characters.
            When you click "step" again they should go back to slash characters and so on.
            When you click "start", you should observe the bears heading towards walls
            and then hugging the walls in a counterclockwise direction.
            They will sometimes bump into each other and go off in other directions,
            but their tendency should be to follow along the walls.
         */

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
