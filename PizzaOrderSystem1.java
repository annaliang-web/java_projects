
/**
 * Dicky's Square Pizza Restaurant  - Version 1 - age specail for entire order 20% off (regardless of how many eligible members)
 * A program calculates the cost of the pizza. 
 * Each pizza box costs $6.99 
 * Every fifth pizza box is free (5th, 10th, 15th, …), regardless of age. 
 */
import java.util.Scanner;
public class PizzaOrderSystem1{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    final double tax = 0.1; //10%
    final double pizzaCost = 6.99;
    double total = 0;
    String yes = "yes";
    //============================== while loop
    while (Character.toLowerCase(yes.charAt(0)) == 'y') {
      System.out.println("\n\uD83C\uDF55 \uD83C\uDF55 \uD83C\uDF55  Dicky's Square Pizza Restaurant \uD83C\uDF55 \uD83C\uDF55 \uD83C\uDF55 ");      
      System.out.println("\u2728 Pizza " + pizzaCost + "/box \u2728 every fifth box gets free! \n");
      boolean hasDiscount = false;
      double subTotal = 0;
      System.out.print("\u261E Enter the number of family members dining: ");
      int numMembers = keyboard.nextInt();
      System.out.print("\u261E Enter boxes of pizza to enter: ");
      int numBoxes = keyboard.nextInt();
      System.out.print("\u261E Available funds for ordering: ");
      double fund = keyboard.nextDouble();
      subTotal = (numBoxes - numBoxes / 5)* pizzaCost;
      System.out.printf("\u261E Subtotal: $%.2f \n", subTotal);
      for (int i = 1; i <= numMembers; i++) {
        System.out.print("\u261E Enter family member " + i + " age: ");
        int age = keyboard.nextInt();
        if (age < 5 || age > 65) {
          hasDiscount = true;
        }
      }
      
      System.out.println("\n---------- \uD83C\uDF55 Order Detail \uD83C\uDF55 -----------");
      if (hasDiscount) {
        subTotal = subTotal * 0.8; //20% off
        System.out.println("\u261E You get 20% off of your order! ");
      }
      if ((numBoxes / 5) > 0) {
        System.out.printf("\uD83C\uDF55 You have %d free pizza! \uD83C\uDF55 \n", (numBoxes/5));
      }
      System.out.printf("\u261E Subtotal: $%.2f \n", subTotal);
      System.out.println("\u261E Tax: 10%");
      total = subTotal + subTotal*tax;
      System.out.printf("\u261E Total: $%.2f \n", total);
      if (fund < total) {
        System.out.println("Sorry, you don't have enough money to order \uD83D\uDE22");
      }
      keyboard.nextLine();
      System.out.print("Would you like to enter again? y/n ");
      yes = keyboard.nextLine();
    }// while ends
    System.out.println("Enjoy your meal! \uD83C\uDF5D");
  }// main ends
}