//Marjie Silva: Handling Input Week 1: OOP


package com.company;


import java.util.Scanner;       //allows input from user

public class Main {               //public class name is the same as program name


    public static void main(String[] args) {
        String studentName="";
        String studentYear="";
        double studentGPA=-1;
        Scanner myScanner = new Scanner(System.in); //creating myScanner for user input
        //myStudent newStudent = new myStudent(studentName, academicYear, gpa);
        int menuOption;

        do {
            menuOption = theMenu();
            switch (menuOption) {           //begining of switch showing menu options
                case 1:
                   studentName = studentsName();             //students name method to get student name
                    break;
                case 2:
                    studentYear = academicYear();             //academic year method
                    break;
                case 3:
                    studentGPA= gpa();                          //gpa method
                    break;
                case 4:
                    studentInfo(studentName,studentYear,studentGPA);                  //display student info
                    break;
                case 5:
                    exit();                         //exit program
                    break;
            }
        } while (menuOption != 5);                  //do while option 5(exit) is not chosen

    }

    public static int theMenu() {                       //method to show menu
        Scanner myScanner = new Scanner(System.in);             //scanner for user input

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

    public static String studentsName() {                         //student name method, scanner, get user input
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter Students Name:");
        return myScanner.nextLine();

    }

    public static String academicYear() {                     //academic year method, scanner get user input
        Scanner myScanner = new Scanner(System.in);
        try {                                                       //error handling
            String[] academicYear = {"freshman", "sophomore", "junior", "senior"};
            System.out.println("Enter the Students Academic Year:");
            return myScanner.nextLine();                                       //how to get user to only input f,s,j,s??????
        }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return "";
    }

    public static double gpa() {                              //gpa method, scanner again? why??
        double gpa=-1;
        Scanner myScanner = new Scanner(System.in);
        do {                                                    //do loop begins
            System.out.println("Enter the Students GPA:");
            try{                                                        //error handling, how to get user to enter only valid double
                gpa = myScanner.nextDouble();
                if (gpa >= 0.0 && gpa <= 4.0){
                    return  gpa;
                }else{
                    gpa = -1;
                    System.out.println("Enter number between 0.0 and 4.0:");
                }
            }catch(Exception e){
                System.out.println("Not a double");
                myScanner.nextLine();
                gpa = -1;
            }
        }while(gpa < 0 || gpa > 4.0);                     //do loop ends.
        return gpa;
    }


    public static void studentInfo(String name, String acYear, double gpa) {                              //display student info
        //myStudent newStudent = new myStudent(studentsName(),academicYear(),gpa());        //create student??
        System.out.println("The Students Name is:" + name);                            // need to print name, year and gpa on console
        System.out.println("The Students Academic Year is:" + acYear);
        System.out.println("The Students GPA is:" + gpa);
    }

    public static void clearScn(){                              //found clear screen on many websites, execute
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void exit() {                             //exit method, exits the program
        System.out.println("Thank you, Goodbye!");
        System.exit(0);
    }
}













