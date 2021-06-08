package cmpt213.assignment1.tasktracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    //Static field:
    public static ArrayList<Task> tasks = new ArrayList<Task>();//array object stores many task objects(tasks)
    public static Scanner keyboard = new Scanner(System.in); //for keyboard input
    public static int countIncomplete = 0;//count number of (complete == false)incomplete tasks
    private static PrintWriter taskFile;
    private static final Type TASKTYPE = new TypeToken<ArrayList<Task>>(){
    }.getType();

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            taskFile = new PrintWriter("taskFile.json");//create a json file
            File readTaskFile = new File("taskFile.json");//read the json file
            JsonReader jReader = new JsonReader(new FileReader(readTaskFile));
            ArrayList<Task> data = gson.fromJson(jReader,TASKTYPE);

        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("File not found.");
        }
        //=========== Setup menu interface ============
        String[] menuOptions = {"List all tasks", "Add a new task", "Remove a task",
                "Mark a completed task", "Overdue incomplete tasks", "Upcoming incomplete tasks",
                "Exit"};
        Menu menu = new Menu("To do List!",menuOptions);
        menu.displayMenu();  //Display Title and Menu options
        menu.chooseAmenuOption();//Read user input from menu options 1 to 7
    }//main ends

    //======= Option1: List all tasks
    public static void listAllTasks(){
        handleNoTask(); //print "no task to show" if no task, then return to main menu
        for (int i = 0; i < tasks.size(); i++) {// i+1 is also the task's number
            int taskNum = i +1;
            System.out.println("***Task " + taskNum);
            System.out.println(tasks.get(i).toString());
        }
    }//listAllTask ends

    //========= Option2: add a task
    public static void addATask() {
        System.out.print("-> Enter a task name: ");//name
        String name = keyboard.nextLine();
        while (name.length() == 0 || name.trim().length() == 0) {
            System.out.print("~Task name cannot be empty or space-only. Please enter a name: ");
            name = keyboard.nextLine();
        }
        System.out.println();/// ????????-------------------
        System.out.print("-> Enter task notes: ");//notes
        String notes = keyboard.nextLine();

        System.out.print("-> Enter YEAR of due date: ");//Year
        int year = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("-> Enter MONTH of due date(1-12): ");//Month
        int month = keyboard.nextInt();
        System.out.print("-> Enter DAY of due date(1-28/29/30/31): ");//day
        int day = keyboard.nextInt();
        keyboard.nextLine(); // Java 8 '\n' clear out
        do{//validate input date
            try{
                LocalDate.of(year, month, day);
                break;//break the loop if input date is valid
            }catch (DateTimeException e){
                System.out.println("Date is incorrect!");
            }
            System.out.print("Please enter YEAR of due date:  ");//year
            year = keyboard.nextInt();
            System.out.print("-> Enter MONTH of due date(1-12): ");//Month
            month = keyboard.nextInt();
            System.out.print("-> Enter DAY of due date(1-28/29/30/31): ");//day
            day = keyboard.nextInt();
        }while(true);
        keyboard.nextLine();//clear out
        System.out.print("-> Enter HOURS of due date(0-23): ");//hours
        int hours = keyboard.nextInt();
        while (hours < -1 || hours >23) {//handle negative/zero/over 24hour
            System.out.print("~~Invalid input. Please enter hours of due date(0-23):  ");
            hours = keyboard.nextInt();
        }
        System.out.print("-> Enter MINUTES of due date(0-59): ");//minutes
        int minutes = keyboard.nextInt();
        while (minutes < -1 || minutes> 59) {//handle negative/zero/over 60mins
            System.out.print("~~Invalid input. Please enter minutes of due date(0-59):  ");
            minutes = keyboard.nextInt();
        }
        GregorianCalendar dueDate = new GregorianCalendar(year, month-1, day, hours, minutes);
        boolean completed = false;
        Task newTask = new Task(name, notes, dueDate, completed); //put new task to tasks arrayList
        tasks.add(newTask);
        countIncomplete++; //count incomplete task from a new task
        System.out.println("*** Task " + name + " added. ***");
    }//addATask ends

    //========= Option3: remove a task
    public static void removeATask(){
        if(tasks.size()>=1) {
            listAllTasks(); //option1 list
            //---------------- sort listAllTasks(); by due date
            System.out.print("-> Enter the task number you want to remove(0 to cancel): ");
            int taskNum = keyboard.nextInt();
//            handleNegativeZero(taskNum);
            while(taskNum < 0 || taskNum > tasks.size()){ //validate numbers
                System.out.print("-> Invalid input. Please enter again: " );
                taskNum = keyboard.nextInt();
            }
            if (taskNum != 0){
                System.out.println("*** " + tasks.get(taskNum-1).getName() + " is removed ***");
                tasks.remove(taskNum-1);
            }
            keyboard.nextLine();//clear out extra line
        }else{  handleNoTask(); }//print "no task to show" if no task
    }//removeATask ends

    //========= Option4: mark complete a task
    public static void markCompleted() {
        if (countIncomplete == 0) {
            System.out.println("--> No incomplete tasks to show.");
        }
        else if(tasks.size() ==0){
            handleNoTask();
        }else{
            for (int i = 0; i < tasks.size(); i++) { //Display incomplete tasks
                if (tasks.get(i).getComplete() == "No") {
                    int taskN = i + 1;
                    System.out.println("***Task" + taskN + "\n" + tasks.get(i).toString());
                }
            }
            //---------------- sort listAllTasks(); by due date
            System.out.print("-> Enter a task number to set completed(0 to cancel): ");
            int taskNum = keyboard.nextInt();
//            handleNegativeZero(taskNum);
            while(taskNum < 0 || taskNum > tasks.size()){
                System.out.print("-> Invalid input. Please enter again: " );
                taskNum = keyboard.nextInt();
            }
            if (taskNum != 0){//user not press 0 cancel to select a task
                tasks.get(taskNum-1).setComplete(true); //mark it
                System.out.println("*** " + tasks.get(taskNum-1).getName() + " Completed ***.");
                countIncomplete--;
            }
            keyboard.nextLine();//clear out extra line
        }//else ends
    }//markComplete ends

    //=========== Option 5: List overdue incomplete tasks
    public static void listOverdueIncomplete(){
        int countOverdue=0;
        GregorianCalendar now = new GregorianCalendar();
        if(tasks.size() > 0){
            for (int i = 0; i <tasks.size(); i++){//retieve all overdue tasks that are under incomplete status
                if (tasks.get(i).getComplete() == "No") {
                    if (tasks.get(i).getDueDate().compareTo(now) == -1) { //return overdue value
                        int taskNum = countOverdue +1;
                        System.out.println("***Task" + taskNum + ":");
                        System.out.println("   Name: " + tasks.get(i).getName()+ "\n" +
                                "   Notes: " + tasks.get(i).getNotes()+ "\n" +
                                "   Due date: " + tasks.get(i).getDueDate().getTime());
                        countOverdue++;
                    }
                }
            }//for loop ends
            if(countOverdue == 0){
                System.out.println("--> No overdue incomplete tasks to show.");
            }
        }//if has tasks
        else {
            handleNoTask();//Display if no tasks to show
        }
    }//listOverdueIncomplete ends

    public static void listUpcomingIncomplete(){
        int countUpcoming = 0;
        GregorianCalendar now = new GregorianCalendar();
        if (tasks.size()>0){
            for (int i = 0; i <tasks.size() ; i++) {
                if(tasks.get(i).getComplete()=="No"){
                    if (tasks.get(i).getDueDate().compareTo(now)==1){//return upcoming value
                        int taskNum = countUpcoming +1;
                        System.out.println("***Task" + taskNum + ":");
                        System.out.println("   Name: " + tasks.get(i).getName()+ "\n" +
                                "   Notes: " + tasks.get(i).getNotes()+ "\n" +
                                "   Due date: " + tasks.get(i).getDueDate().getTime());
                        countUpcoming++;
                    }
                }
            }//for loops ends
            if (countUpcoming == 0){
                System.out.println("--> No upcoming incomplete tasks to show.");
            }
        }//if has tasks
        else {
            handleNoTask();//Display if no tasks to show
        }
    }//listUpcomingIncomplete ends


    //=========== Exit the program, option 7
    public static void exit(){
        //=========== Serialize(Save) arrayList objects in Json
        String jsonTaskArrayList = new Gson().toJson(tasks);
        taskFile.write(jsonTaskArrayList);//write tasks arrayList on json file
        taskFile.close();
        System.out.println("*** Good bye! ***");
    }

    //-------------- Other methods ------------------
    public  static  void handleNoTask(){
        if (tasks.size() == 0) {
            System.out.println("\n --> No task to show.");
        }
    }
}//Main class ends
