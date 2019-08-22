
/**
 * The Die class simulates a six-sided dice.
 */

import java.util.Random; 
import java.util.Scanner;

public class Die{
  //fields
  private int sides, value; 

  //constructor
  public Die(int sides_init){
    sides = sides_init;
    roll();
  }

  //accessor
  public int getSides(){
    return sides;
  }
  public int getValue(){
    return value;
  }

  //other method
  Random randNum = new Random();
  public void roll(){
    value = randNum.nextInt(sides) + 1;
  }

  
}