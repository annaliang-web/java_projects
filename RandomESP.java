/*
 *ESP Game 
 * A program tests your ESP (extrasensory perception). The program should randomly select
 * the name of a color from the following list of words: Red, Green, Blue,
 * Orange, Yellow To select a word, the program can generate a random number.
 * For example, if the number is 0, the selected word is Red, if the number is
 * 1, the selected word is Green, and so forth. Next, the program should ask the
 * user to enter the color that the computer has selected. After the user has
 * entered his or her guess, the program should display the name of the randomly
 * selected color. The program should repeat this 10 times and then display the
 * number of times the user correctly guessed the selected color.
 * 
 */

import java.util.Random;
import java.util.Scanner;

public class RandomESP{
	public static void main(String[] args){
    String color; int times=0;
    Random randomNum = new Random(); //create raondomNum object
    Scanner keyboard = new Scanner(System.in);

    System.out.print("\t \u2728 ESP Game \u2728 \nYou can guess 10 times.\n");
    for (int i = 1; i <= 10; i++) {
      int num = randomNum.nextInt(5); // 0,1,2,3,4
      if (num == 0) {
        color = "Red";
      } else if (num == 1) {
        color = "Green";
      } else if (num == 2) {
        color = "Blue";
      } else if (num == 3) {
        color = "Orange";
      } else {
        color = "Yellow";
      }
      
      System.out.print("\u261E Guess a color: ");
      String guess = keyboard.nextLine();
      System.out.println("Result: " + color);
      System.out.println();//blank line
      if (color.equalsIgnoreCase(guess))
        times++;
    } //for ends    
    System.out.println("\u261E You have " + times + " correct guesses.");
  }
}
