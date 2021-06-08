package cmpt213.assignment1.tasktracker;
//CMPT 213 -OOD in Java Assignment 1 - Chaoer Liang - May 30, 2021
//Task tracker program - Menu class
import java.util.Scanner; //for user input

/**
 The Menu class simulates a menu interface to users.
 */
public class Menu {
    //Instance field:
    private String title;
    private  String[] menuOptions;
    //Static field:
    public static Scanner keyboard = new Scanner(System.in);

    //Instance construnctors:
    public Menu(){ //no-arg constructor
        title = "default";
        menuOptions = new String[0];
    }
    public Menu(String title_param, String[] menuOptions_param){
        title = title_param;
        //create the array menu
        menuOptions = new String[menuOptions_param.length];//assign same length to menuOptions
        for (int i = 0; i < menuOptions_param.length; i++) {
            menuOptions[i] = menuOptions_param[i]; //deep copy
        }
    }

    //===============Instance Setter =================
    public void renameTitle(String title_param){
        title = title_param;
    }

    //===============Instance Accessor =================

    public void displayMenu(){ // get menu and the surrounding box
        //Box drawing + title
        int titleLength = title.length();
        System.out.println();
        for (int i = 0; i < titleLength + 4; i++) {
            System.out.print("#");
        }
        System.out.println();
        System.out.println("# " + title + " #");
        for (int i = 0; i < titleLength + 4; i++) {
            System.out.print("#");
        }
        System.out.println();

        //Display each menu option
        for (int i = 1; i <= menuOptions.length; i++) {
            System.out.println(i + ". " + menuOptions[i-1]);// i + each array item
        }
    }

    //============== Other Instance Methods ==============
    public void chooseAmenuOption() { //Choose a menu option 1 to 7
        System.out.print("Please choose an option from 1 to 7: ");
        // boolean exit = false; // initial exit system
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        while (choice > 7 || choice < 1) { //handle intergers not in 0< choice < 8
            System.out.println("Invalid input. Please choose an option from 1 to 7: ");
            choice = keyboard.nextInt();
        }
        while (choice != 7) {
            switch (choice) {
                case 1:
                    //listTasks()
                    Main.listAllTasks();
                    break;
                case 2:
                    Main.addATask();
                    break;
                case 3:
                    Main.removeATask();
                    break;
                case 4:
                    Main.markCompleted();
                    break;
                case 5:
                    Main.listOverdueIncomplete();
                    break;
                case 6:
                    Main.listUpcomingIncomplete();
                    break;
                default: //Invalid command
                    System.out.print("Invalid input. ");
                    break;
            }//switch ends
            if (choice >= 1 && choice <= 7) { //menu will not show if input options are not 1 to 7
                displayMenu(); // show the menu again after previous input
            }
            System.out.print("Please choose menu options from 1 to 7: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();
        }//while ends - menu options
        Main.exit();// Menu option7 , exit the program
    }//chooseAMenuOptions ends


}//class ends

