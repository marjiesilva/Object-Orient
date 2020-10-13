//Marjie Silva: Handling Input Week 1: OOP


package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;       //allows input from user

public class SilvaHandlingInput {               //public class name is the same as program name


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);         //creating myScanner for user input

        String studentName = "";
        String studentYear = "";

        double studentGPA = -1;

        String answers[];
        answers = new String[5];

        int cont = -1;

        do {
            try {

                theMenu(myScanner);


                cont = myScanner.nextInt();

                answers[cont - 1] = printQuestions(cont, myScanner);    //saving all answers in array, -1 because count starts at 0!

                switch (cont) {           //begining of switch showing menu options
                    case 1:
                        studentName = answers[cont - 1];             //retrieving student name (1-1=0) option 0 is students name
                        break;
                    case 2:
                        studentYear = answers[cont - 1].toLowerCase();             //retrieving student name (2-1=1) option 1 is student name
                        break;
                    case 3:
                        studentGPA = Double.parseDouble(answers[cont - 1]);                            //gpa method
                        System.out.println("Press Enter to Clear Terminal");
                        myScanner.nextLine();
                        clearTer();
                        break;
                    case 4:
                        studentInfo(studentName, studentYear, studentGPA);
                        System.out.println("Press Enter to Clear Terminal");
                        myScanner.nextLine();
                        clearTer();
                        break;
                    case 5:
                        exit();                         //exit program
                        break;
                }
            }catch(Exception e){
                System.out.println("Enter valid option between 1 and 5:");
                myScanner.nextLine();
                System.out.println("Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            }
        } while (cont != 5);                  //do while option 5(exit) is not chosen

    }
    public static void checkData(String name, String academicYear, double gpa){
        ArrayList<String> inValid = new ArrayList<String>();
        int missingData = 0;
        missingData = missingData(name, academicYear, gpa);

        inValid.add(invalidAcYrEntry(academicYear));
        inValid.add(invalidGpa(gpa));
        inValid.removeAll(Collections.singleton(""));               //deletes all ""

        String invalidAcYr = invalidAcYrEntry(academicYear);
        String invalidGpa = invalidGpa(gpa);
        if (missingData > 0) {
            return;
        }else if (!invalidAcYr.isEmpty() || !invalidGpa.isEmpty()) {
            System.out.printf("%s%s\n", invalidAcYr, invalidGpa);               //%s = string value
        }else {
            System.out.println("The Students Name is" + name);
            System.out.println("The Students Academic Year is" + academicYear);
            System.out.println("The Students GPA is" + gpa);
        }
    }

    public static int missingData(String name, String academicYear, double gpa){
        String[] options = {"Student Name", "Students Academic Year", "Students GPA"};
        int countOptions = 0;
        if (name.isEmpty()) {
            System.out.println("You left" + options[0] + "blank.");
        }
        if (academicYear.isEmpty()) {
            System.out.println("You left" + options[1] + "blank.");
        }
        if (gpa < 0) {
            System.out.println("You left" + options[2] + "blank.");
        }
        return countOptions;
    }

    public static String studentsName(Scanner myScanner) {                         //student name method, scanner, get user input
        //Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter Students Name:");
        String myString = myScanner.nextLine();
        return myString;
    }

    public static String invalidAcYrEntry(String academicYear) {                     //academic year method, scanner get user input
        ArrayList<String> validAys = new ArrayList<String>();
        validAys.add("freshmen");
        validAys.add("sophomore");
        validAys.add("junior");
        validAys.add("senior");


        if(!validAys.contains(academicYear)){
            return "It appears you've entered an invalid Academic Year.";
        }
        return "";
        /*String studentYear = "";
            String[] academicYear = {"freshman", "sophomore", "junior", "senior"};
            System.out.println("Enter the Students Academic Year:");
            studentYear = myScanner.nextLine();
            int countErr = 0;
            for (int i = 0; i<3;i++){
                if (studentYear.equals(academicYear[i])){
                    studentYear = studentYear;
                    return studentYear;
                }else {
                    countErr++;
                }
            }
            if (countErr > 0){
                System.out.println("Enter valid academic year:");
            }*/
                /*if (studentYear == "freshman"){
                    studentYear = myScanner.nextLine();
                }
                if (studentYear == "sophomore"){
                    studentYear = myScanner.nextLine();
                }
                if (studentYear == "junior"){
                    studentYear = myScanner.nextLine();
                }
                if (studentYear == "senior"){
                    studentYear = myScanner.nextLine();
                }
                else if(){
                    System.out.println("Enter valid academic year");
                }

        return ;*/
    }

    public static String invalidGpa(double gpa) {
        Scanner myScanner = new Scanner(System.in);
        do {                                                    //do loop begins
            System.out.println("Enter the Students GPA:");
            try{                                                        //error handling, how to get user to enter only valid double
                if (gpa >= 0.0 || gpa <= 4.0){
                    gpa = gpa;
                }else{
                    gpa = -1;
                    System.out.println("Enter number between 0.0 and 4.0:");
                }
            }catch(Exception e){
                System.out.println("This is not a double");  //this keeps looping??
                myScanner.hasNextLine();
                gpa = -1;
            }
        }while(gpa < 0 || gpa > 4.0);           //do loop ends.
        return "";
    }


    public static void studentInfo(String name, String academicYear, double gpa) {                              //display student info
        System.out.println("The Students Name is:" + name);                            // need to print name, year and gpa on console
        System.out.println("The Students Academic Year is:" + academicYear);
        System.out.println("The Students GPA is:" + gpa);
    }

    public static void clearTer(){                              //found clear screen on many websites, execute
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void exit() {                             //exit method, exits the program
        System.out.println("Thank you, Goodbye!");
        System.exit(0);
    }

    private static String printQuestions(int arryPoist, Scanner myScan) {       //this is a simpler way to print the questions and minimizing my code
        String returnValue;
        if(arryPoist > 3) {
            return "Exit";
        }
        String[] questions = {
                "Enter Students Name:",
                "Enter Students Academic Year:",
                "Enter Students GPA:"};
        System.out.println(questions[arryPoist-1]);             //-1 because there are 3 questions starting at 0 (0,1,2)
        returnValue = myScan.next();
        return returnValue;
    }

    public static int theMenu(Scanner myScanner) {                       //method to show menu
        //Scanner myScanner = new Scanner(System.in);             //scanner for user input

        int chooseOption;                                       //chose int 1-5 options
        System.out.println("1. Enter the Students Name:");
        System.out.println("2. Enter the Students Academic Year:");
        System.out.println("3. Enter the Students GPA:");
        System.out.println("4. Display Students Info:");
        System.out.println("5. Exit");
        System.out.println("Choose Menu Option:");

        chooseOption = myScanner.nextInt();                 //get user input options

        return chooseOption;                                    //return user choice
    }

}













