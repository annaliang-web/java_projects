/**
 * 18. Fishing Game Simulation For this assignment, you will write a program
 * that simulates a fishing game. In this game, a six-sided die is rolled to
 * determine what the user has caught. Each possible item is worth a certain
 * number of fishing points. The points will remain hidden until the user is
 * finished fishing, and then a message is displayed congratulating the user,
 * depending on the number of fishing points gained. Here are some suggestions
 * for the game’s design: 
 * • Each round of the game is performed as an iteration of a loop that repeats as long as the player wants to fish for more items. 
 * •At the beginning of each round, the program will ask the user whether or not
 * he or she wants to continue fishing. • The program simulates the rolling of a
 * six-sided die (use the Die class that was shown in Code Listing 6-14). 
 * • Each item that can be caught is represented by a number generated from the die;
 * for example, 1 for “a huge fish”, 2 for “an old shoe”, 3 for “a little fish”,
 * and so on. 
 * • Each item the user catches is worth a different amount of points. 
 * • The loop keeps a running total of the user’s fishing points. 
 * •After the loop has finished, the total number of fishing points is displayed,
 * along with a message that varies depending on the number of points earned.
 */

import java.util.Scanner;
public class FishingGame {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int points = 0;
    System.out.print("Default dice is 6 sides. Do you want to choose sides of a dice? y/n: ");
    String yes = keyboard.nextLine();
    if (Character.toLowerCase(yes.charAt(0)) == 'y') {
      System.out.print("Enter a number of sides(Maximum 6): ");
      int sides = keyboard.nextInt();
      keyboard.nextLine();
      Die dice = new Die(sides);
      System.out.print("Press yes to roll the dice: ");
      yes = keyboard.nextLine();
      while (yes.length() > 0 && Character.toLowerCase(yes.charAt(0)) == 'y') {
        dice.roll();
        switch (dice.getValue()) {
        case 6:
          System.out.println("A huge salmon!");
          points = points + 6;
          break;
        case 5:
          System.out.println("Wow, an amberjack");
          points = points + 5;
          break;
        case 4:
          System.out.println("Ha, a bonito");
          points = points + 4;
          break;
        case 3:
          System.out.println("A common trout");
          points = points + 3;
          break;
        case 2:
          System.out.println("Oh, a frog?");
          points = points + 2;
          break;
        case 1:
          System.out.println("An old shoe...");
          points = points + 1;
        default:
          break;
        }
        System.out.print("Roll again?(y/n) ");
        yes = keyboard.nextLine();
      }
      System.out.println("Total points: " + points);
    } 
    else {
      Die dice = new Die(); // no-arg is 6 sides
      System.out.print("Press yes to roll the dice: ");
      yes = keyboard.nextLine();
      while (yes.length() > 0 && Character.toLowerCase(yes.charAt(0)) == 'y') {
        dice.roll();
        switch (dice.getValue()) {
        case 6:
          System.out.println("A huge salmon!");
          points = points + 6;
          break;
        case 5:
          System.out.println("Wow, an amberjack");
          points = points + 5;
          break;
        case 4:
          System.out.println("Ha, a bonito");
          points = points + 4;
          break;
        case 3:
          System.out.println("A common trout");
          points = points + 3;
          break;
        case 2:
          System.out.println("Oh, a frog?");
          points = points + 2;
          break;
        case 1:
          System.out.println("An old shoe...");
          points = points + 1;
        default:
          System.out.println("Invalid sides, out of range");
        break;
        }
        System.out.print("Roll again?(y/n) ");
        yes = keyboard.nextLine();
      }
      System.out.println("Total points: " + points);
    }

  }
}