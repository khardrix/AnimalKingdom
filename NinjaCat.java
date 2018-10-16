package com.github.khardrix.AnimalKingdom;

// IMPORTS of needed tools and plug-ins.
import java.awt.*;


public class NinjaCat extends Critter{

    private int moveCount = 0;
    private boolean inStealth = true;


    public NinjaCat(){

        /*
            You decide! --> :

         */


    }


    public Color getColor(){

        /*
            You decide! --> :
            While NinjaCat is in stealth looking for its prey,
            the NinjaCat is represented in cyan.
            When the NinjaCat attacks, it will be represented with magenta!
         */

        if(inStealth){
            return Color.CYAN;
        }else{
            return Color.MAGENTA;
        }
    }


    public String toString(){

        /*
            You decide! --> :
            While NinjaCat is in stealth looking for its prey,
            the NinjaCat is represented as "@".
            When the NinjaCat attacks, it will be represented with "M"!
         */

        if(inStealth){
            return "@";
        }else{
            return "M";
        }
    }


    public Action getMove(CritterInfo info){

        /*
            You decide! --> :
            always infect if an enemy is in front,
            otherwise hop if possible,
            otherwise turn left.
         */

        moveCount++;
        if(info.getFront() == Neighbor.OTHER) {
            inStealth = false;
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            inStealth = true;
            return Action.HOP;
        }else{
            return Action.LEFT;
        }
    }
}
