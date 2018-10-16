package com.github.khardrix.AnimalKingdom;

// IMPORTS of needed tools and plug-ins.
import java.awt.*;


public class Giant extends  Critter{

    private int moveCount = 0;


    public Giant(){

        /*
            Giant: Try running the simulator with just 30 giants in the world.
            They should all be displayed as "fee".
            This should be true for steps 0, 1, 2, 3, 4, and 5.
            When you get to step 6, they should all switch to displaying "fie"
            and should stay that way for steps 6, 7, 8, 9, 10, and 11.
            Then they should be "foe" for steps 12, 13, 14, 15, 16, and 17.
            And they should be "fum" for steps 18, 19, 20, 21, 22, and 23.
            Then they should go back to "fee" for 6 more steps, and so on.
            When you click "start", you should observe the same kind of wall-hugging behavior
            that bears have, but this time in a clockwise direction.
         */

        toString();
    }


    public Color getColor(){

        /*
            Color.GRAY
         */

        return Color.GRAY;
    }


    public String toString(){

        /*
            "fee" for 6 moves,
            then "fie" for 6 moves,
            then "foe" for 6 moves,
            then "fum" for 6 moves, then repeat.
         */

        if(moveCount > 24){
            moveCount = 0;
        }

        if(moveCount <= 6){
            return "fee";
        } else if(moveCount <= 11){
            return "fie";
        } else if(moveCount <= 17){
            return "foe";
        }else{
            return "fum";
        }
    }

    public Action getMove(CritterInfo info){

        /*
            always infect if an enemy is in front,
            otherwise hop if possible,
            otherwise turn right.
         */

        moveCount++;
        return Action.HOP;
    }
}
