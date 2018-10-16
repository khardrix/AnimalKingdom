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

        /*
            Tiger: Try running the simulator with just 30 Tigers in the world.
            You should see about one third of them being red and one third being green
            and one third being blue.
            Use the "step" button to make sure that the colors alternate properly.
            They should keep these initial colors for three moves.
            That means that they should stay this color
            while the simulator is indicating that it is step 0, step 1, and step 2.
            They should switch colors when the simulator indicates that
            you are up to step 3 and should stay with these new colors for steps 4 and 5.
            Then you should see a new color scheme for steps 6, 7, and 8 and so on.
            When you click "start" you should see them bouncing off of walls.
            When they bump into a wall, they should turn around
            and head back in the direction they came.
            They will sometimes bump into each other as well.
            They shouldn't end up clustering together anywhere.
         */

        randomizeColor();
    }


    public Color getColor(){

        /*
            Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE)
            and uses that color for three moves, then randomly picks one of those colors again
            for the next three moves, then randomly picks another one of those colors
            for the next three moves, and so on.
         */

        Color newColor;
        if(moveCount % 3 == 0){
            moveCount = 0;
            do{
                newColor = randomizeColor();
            }while(color == newColor);
            color = newColor;
        }
        return color;
    }


    public Color randomizeColor(){

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
