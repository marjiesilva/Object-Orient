package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SilvaOOP01 {

    public static void main(String[] args) {

        Students myStudents;
        myStudents = new Students();
        Scanner myScanner = new Scanner(System.in);
        File myFile = new File(filePath(myScanner));

        String studentName="";
        String studentYear = "";
        double studentGpa=-1;
        int invalidEntries=0;
        int missingQuestion = 0;

        String response ="-1";


        ArrayList<Students>students =  new ArrayList<Students>();
        students.add(myStudents);
        //Students myStudents = new Students(studentName, studentYear, studentGpa);
        do{
            mainMenu();
            System.out.println("Please Enter Your Numeric Selection");
            response=myScanner.next();
            if(response.equals("1")){
                System.out.println("Enter the Students Name:");
                myStudents.setStudentName(myScanner.next());
                //students.add(myStudents);
                System.out.println(myStudents.getStudentName());
                //studentName = myStudents.studentName;
                clearTer();
            }else if(response.equals("2")){
                System.out.println("Enter the Students Year:");
                myStudents.setStudentYear(myScanner.next().toLowerCase());
                //studentYear = myStudents.studentYear;
                invalidEntries = validEntry(myStudents.getStudentYear(),0);
                if(invalidEntries>0){
                    myStudents.setStudentYear("");
                }
                myScanner.nextLine();
                System.out.println("Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            }else if(response.equals("3")){
                System.out.print("Enter the Students GPA: ");
                try {
                    //myStudents.studentGpa = myScanner.nextDouble();
                    myScanner.nextLine();
                    myStudents.setStudentGPA(myScanner.nextDouble());
                    //studentGpa = myStudents.studentGpa;
                    invalidEntries =validEntry("senior", myStudents.getStudentGpa());
                    if(invalidEntries>0){
                        myStudents.setStudentGPA(-1);
                    }
                    myScanner.nextLine();
                    System.out.println("Press Enter to clear terminal");
                    myScanner.nextLine();
                    clearTer();
                }catch (Exception ex){
                    System.out.println("Only a double value is acceptable. Please try again");
                    studentGpa=-1;
                    myScanner.nextLine();
                    System.out.println("Press Enter to clear terminal");
                    myScanner.nextLine();
                    clearTer();
                }
            }else if(response.equals("4")){
                //print the current data for the student
                //Students myStudents = new Students(studentName, studentYear, studentGpa);
                students.add(myStudents);
                /*for (Students s : students){
                    s.getStudentName();
                }*/
                System.out.println("Students Name is: " + myStudents.getStudentName());
                System.out.println("Students Year is: " + myStudents.getStudentYear());
                System.out.println("Students GPA is: " + myStudents.getStudentGpa());
                myScanner.nextLine();
                System.out.println("Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            }else if (response.equals("5")) {
                students.add(myStudents);
                missingQuestion = missingData(myStudents.getStudentName(), myStudents.getStudentYear(), myStudents.getStudentGpa());
                if(missingQuestion == 0 && invalidEntries == 0){
                    writeToFile(myStudents.getStudentName(), myStudents.getStudentYear(), myStudents.getStudentGpa(),myFile);
                    myScanner.nextLine();
                    System.out.println("Press Enter to Clear Terminal");
                    myScanner.nextLine();
                    clearTer();
                }else {
                    System.out.println("Some entries are invalid.");
                    myScanner.nextLine();
                    System.out.println("Press Enter to Clear Terminal");
                    myScanner.nextLine();
                    clearTer();
                }
            }else if(response.equals("6")) {
                fileReader(myFile);
            }

        }while(!response.equals("7"));
    }
    public static String filePath(Scanner scn){
        String cust = "n";
        String pth="";
        System.out.println("Enter Custom File Path(Y/N)");
        cust = scn.nextLine();
        cust = cust.toLowerCase();
        switch (cust){
            case "y":
                System.out.println("Enter path you'd like to use for this session:");
                pth = scn.nextLine();
                break;
            default:
                pth = "UserDatabase.txt";

        }
        return pth;
    }


    public static void writeToFile(String getStudentName, String getStudentYear, Double getStudentGpa, File myFile){
        String gpaString = String.valueOf((getStudentGpa));

        //create a new File object

        //attempt to write to file
        try {
            //create a new file writer object to write to a file true will append to file
            FileWriter myFileWriter = new FileWriter(myFile,true);
            //test if file has already been created
            if (myFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("This file already exists");
            }
            //write to the new file. NOTE this will ALWAYS overwrite the old file.
            myFileWriter.write("The students name is: "+ getStudentName +"\n");
            myFileWriter.write("The students year is: "+ getStudentYear +"\n");
            myFileWriter.write("The students gpa is: "+ getStudentGpa +"\n");
            //close the file
            myFileWriter.close();
            //catch any errors.
        }catch (IOException e){
            System.out.println("Error occurred");
            e.printStackTrace();

        }
    }

    public static void fileReader(File myFile){
        String line = "";
        try {
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                System.out.println(line);
            }
        } catch (Exception myEx) {
            System.out.println("Error");
        }

    }
    //check if anything is missing. Report back what is Extra Credit 2 and 3
    public static int missingData(String studentName, String studentYear, double studentGpa) {
        String[] questions = {"Students Name", "Students Academic Year", "Students GPA"};
        int countOfMissing = 0;
        if (studentName.isEmpty()) {
            System.out.println("It looks like you left " + questions[0] + " blank");
            countOfMissing++;
        }
        if (studentYear.isEmpty()) {
            System.out.println("It looks like you left " + questions[1] + " blank");
            countOfMissing++;
        }
        if (studentGpa < 0){
            System.out.println("It looks like you left " + questions[2] + " blank");
            countOfMissing++;
        }
        return countOfMissing;
    }
    public static int validEntry(String year, double gpa){
        ArrayList<String> validAys = new ArrayList<String>();
        validAys.add("freshmen");
        validAys.add("sophomore");
        validAys.add("junior");
        validAys.add("senior");

        double lower = 0.0;
        double upper = 4.0;

        if(!validAys.contains(year) && (gpa< lower || gpa > upper)){
            System.out.println("The Year provided is invalid. The GPA appears to be outside the bounds of 0.0 and 4.0");
            return 1;
        }else if(!validAys.contains(year)){
            System.out.println("The Year provided is invalid.");
            return 1;
        }else if(gpa< lower || gpa > upper){
            System.out.println("The GPA appears to be outside the bounds of 0.0 and 4.0");
            return 1;
        }
        return 0;
    }
    //extra credit option 1
    public static void clearTer(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    private static void mainMenu(){
        //Students myStudents = new Students(studentName, studentYear, studentGpa);
        System.out.println("1. Enter Students Name");
        System.out.println("2. Enter Students Academic Year");
        System.out.println("3. Enter Students GPA");
        System.out.println("4. Display Students Info");
        System.out.println("5. Write Data");
        System.out.println("6. Read Data");
        System.out.println("7. Exit");
    }

}
