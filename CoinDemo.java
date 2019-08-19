/**
* Coin Toss Simulator 
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

public class CoinDemo{
  public static void main(String[] args){
    Coin coin = new Coin();
    int headsCount=0, tailsCount = 0;

    System.out.println("***** Toss the coin! *****");
    System.out.println(coin.getSidesUp());//show one side up before tossing

    for(int i = 1; i <= 20; i++){
      coin.toss();// user toss coin 20 times
      System.out.println(coin.getSidesUp());// show one side up before tossing
      if(coin.getSidesUp() == "heads"){
        headsCount++;
      }
      else{
        tailsCount++;
      }
    }//for ends

    System.out.println("Result: " + "heads: " + headsCount + " tails: " + tailsCount);
    
    if (headsCount > tailsCount)
      System.out.println("Head won.");
    else if(headsCount < tailsCount)
      System.out.println("Tail won.");
    else 
      System.out.println("Nil");

  }//main ends 
}