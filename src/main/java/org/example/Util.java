package org.example;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Util {

    public boolean pythagoras(int firstSide, int secondSide, int thirdSide){
        if(firstSide == sqrt(pow(secondSide, 2) + pow(thirdSide, 2)) || secondSide == sqrt(pow(firstSide, 2) + pow(thirdSide, 2)) || thirdSide == sqrt(pow(firstSide, 2) + pow(secondSide, 2))){
            return true;
        }
        return false;
    }




}
