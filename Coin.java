
/**
 * Chapter6 - Coin Toss Simulator 
 * Write a class named Coin. The Coin class should have the following field: 
 * • A String named sideUp. The sideUp field will hold either “heads” or “tails” indicating the side of the coin that is facing up. 
 * The Coin class should have the following methods: 
 * • A no-arg constructor that randomly determines the side of the coin that is facing up (“heads” or
 * “tails”) and initializes the sideUp field accordingly. 
 * • A void method named toss that simulates the tossing of the coin. When the toss method is called,
 * it randomly determines the side of the coin that is facing up (“heads” or
 * “tails”) and sets the sideUp field accordingly. 
 * • A method named getSideUp that returns the value of the sideUp field. Write a program that demonstrates the Coin class. The program should create an instance of the class and display the side that is initially facing up. Then, use a loop to toss the coin 20 times. Each time the coin is tossed, display the side that is facing up. The program should keep count of the number of times heads is facing up and the number of times tails is facing up, and display those values after the loop finishes.
 */

import java.util.Random;
import java.util.Scanner;

public class Coin{
  //field
  private String sideUp; // heads or tails

  Random randNum = new Random();
  //no-arg constructor
  public Coin(){
    int value = randNum.nextInt(2); // 0 1
    if(value == 1){
      sideUp = "heads";
    }
    else{
      sideUp = "tails";
    } 
  }//constructor ends

  //other
  public void toss(){
    int value = randNum.nextInt(2); // 0 1
    if (value == 1) {
      sideUp = "heads";
    } else {
      sideUp = "tails";
    }
  }//toss ends

  //accessor
  public String getSidesUp(){
    return sideUp;
  }

}//coin ends