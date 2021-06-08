package cmpt213.assignment1.tasktracker;
//CMPT 213 -OOD in Java Assignment 1 - Chaoer Liang - May 30, 2021
//Task tracker program - TaskInformation class
import java.util.GregorianCalendar;
/**
 The Task class is for holding task information.
 */
public class Task {

    //Instance field:
    private String name;
    private String notes;
    private GregorianCalendar dueDate;
    private boolean completed = false;

    //Constructor:
    public Task(String name_param, String notes_param, GregorianCalendar dueDdate_param, boolean completed_param){
        name = name_param;
        notes = notes_param;
        dueDate = dueDdate_param;//GregorianCalandar
        completed = completed_param;
    }

    //================ Instance Accessor ==============
    public String getName() {
        return name;
    }
    public String getNotes() {
        return notes;
    }
    public GregorianCalendar getDueDate() {
        return dueDate;
    }
    public String getComplete(){
        String yesOrNo = "";
        if (completed == true) {
            yesOrNo = "Yes";
        } else {
            yesOrNo = "No";
        }
        return yesOrNo;
    }

    //================ Instance Mutator ==============
    public void  setName(String new_name) {
        name = new_name;
    }
    public void setNotes(String new_notes) {
        notes = new_notes;
    }
    public void setComplete(boolean completed_param) {
        completed = completed_param;
    }

    //================ Other methods =================
    //   @Override
    public String toString(){
        String displayList = "   Name: " + name +
                "\n   Note: " + notes +
                "\n   Due Date: " + dueDate.getTime() +
                "\n   Completed? " + getComplete();
        return displayList;
    }
//    public void overDueOrUpcoming(){ // check task overdue; should be Instance method !!
//        GregorianCalendar dueDate = new GregorianCalendar(2021,5-1,31,22,59);//month starts from 0
//        GregorianCalendar now = new GregorianCalendar(); //get current time: YMDHM
//        // ----------task information will stored in Json file(user input)
//        System.out.println(dueDate.getTime()); // return dueDate time
//        System.out.println(now.getTime()); // return current time value
//        if(dueDate.compareTo(now)==-1){ //negative is overdue
//            System.out.println("It's overdue!");
//        }else if(dueDate.compareTo(now)==1){ //positive is upcoming
//            System.out.println("Upcoming!");
//        }
//    }//overDueOrUpcoming ends

}

