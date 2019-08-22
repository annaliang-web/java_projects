
/**
 * This program simulates the rolling of dice.
 * Die.java - Die class
 * Test run:
  Computer: 2  You: 3
  Computer: 5  You: 1
  Computer: 3  You: 5
  Computer: 5  You: 5
  Computer: 6  You: 2
  Computer: 4  You: 3
  Computer: 1  You: 2
  Computer: 6  You: 6
  Computer: 4  You: 3
  Computer: 3  You: 5
  Wow, it's a tie.

  Computer: 5  You: 3
  Computer: 5  You: 5
  Computer: 4  You: 2
  Computer: 1  You: 1
  Computer: 1  You: 2
  Computer: 1  You: 6
  Computer: 4  You: 5
  Computer: 6  You: 6
  Computer: 2  You: 4
  Computer: 6  You: 1
  You won! Result: 4 : 3 
 */
import java.util.Scanner;
public class DieDemo{
  public static void main(String[] args){
    //create instances
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter sides you choose(1 to 10 sides): ");
    int input = keyboard.nextInt();
    Die computer = new Die(input);//the sides parameter is to set how many sides of a dice
    Die user = new Die(input);

    int comCount =0, userCount = 0;
    for(int i = 1; i <= 10; i++){
      computer.roll();  user.roll(); //roll dices 10 times
      int comValue = computer.getValue();
      int userValue = user.getValue();
      System.out.println("Computer: " + comValue+ "  " + "You: " + userValue);
      if(comValue > userValue){
        comCount++;
      }
      else if(comValue < userValue){
        userCount++;
      }
    }//for ends

    if(comCount > userCount){
      System.out.printf("Computer won! Result: %d : %d \n", comCount, userCount);
    }
    else if(comCount < userCount){
      System.out.printf("You won! Result: %d : %d \n", userCount, comCount);
    }
    else{
      System.out.println("Wow, it's a tie.");
    }
    
  }
}