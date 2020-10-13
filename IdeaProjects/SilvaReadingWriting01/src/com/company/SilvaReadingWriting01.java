//SilvaReadingWriting02

package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.ArrayList;


public class SilvaReadingWriting01 {

    public static void main(String[] args) {

        String studentName = "";
        String studentYear = "";
        String searchName = "";

        double studentGpa = -1;

        //File myFile = new File("Students.txt");          //file object created
        //String student;                                          //variables to store lines
        //ArrayList<String> data = readDatabase("Studentdatabase.csv");
        ArrayList<String> studentNames = new ArrayList<String>();
        ArrayList<String> schoolYear = new ArrayList<String>();
        ArrayList<String> studentGPA = new ArrayList<String>();
        ArrayList<String> fullStudent = new ArrayList<String>();


        int invalidEntries = 0;

        int missingQuestion = 0;

        Scanner myScanner = new Scanner(System.in);             //scanner for user input

        String response = "-1";


        do {
            mainMenu();                                                 //call main menu function
            System.out.print("Please Enter Your Numeric Selection: ");
            response = myScanner.next();                                  //grabbing users numerical input for main menu options
            if (response.equals("1")) {
                System.out.print("Enter the Students Name: ");
                studentName = myScanner.next();                         //get users input for name and store
                clearTer();                                                 //clear terminal
            } else if (response.equals("2")) {
                System.out.print("Enter the Students Year: ");
                studentYear = myScanner.next().toLowerCase();           //get student year and store lowercase result
                invalidEntries = validEntry(studentYear, 0);
                if (invalidEntries > 0) {
                    studentYear = "";
                }
                myScanner.nextLine();
                System.out.println("Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            } else if (response.equals("3")) {
                System.out.print("Enter the Students GPA: ");
                try {                                                   //error handling for gpa
                    studentGpa = myScanner.nextDouble();                    //gpa = user input and grab result
                    invalidEntries = validEntry("senior", studentGpa);       //why does freshman give error message??
                    if (invalidEntries > 0) {
                        studentGpa = -1;
                    }
                    myScanner.nextLine();
                    System.out.println("Press Enter to clear terminal");
                    myScanner.nextLine();
                    clearTer();
                } catch (Exception ex) {
                    System.out.println("Only a double value is acceptable. Please try again");
                    studentGpa = -1;
                    myScanner.nextLine();
                    System.out.println("Press Enter to clear terminal");
                    myScanner.nextLine();
                    clearTer();
                }
            } else if (response.equals("4")) {                                 //display so user can check their work
                //missingQuestion = missingData(studentName,studentYear,studentGpa);
                //if(missingQuestion == 0 && invalidEntries == 0){
                System.out.println("Students Name is: " + studentName);
                System.out.println("Students Year is: " + studentYear);
                System.out.println("Students GPA is: " + studentGpa);
                //myScanner.nextLine();
                System.out.println("Check your work above and Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            }/*else{
                            System.out.println("Some entries are invalid.");
                            myScanner.nextLine();
                            System.out.println("Press Enter to Clear Terminal");
                            myScanner.nextLine();
                            clearTer();
                        //}
                    }*/ else if (response.equals("5")) {
                //BufferedWriter buffer = null;
                //File myFile = new File("Students.txt");          //file object created
                //String student;
                missingQuestion = missingData(studentName, studentYear, studentGpa);       //verifying missing data
                if (missingQuestion == 0 && invalidEntries == 0) {
                    try {                           //error handling for file writer
                        readDatabase("Studentdatabase.csv");
                        File dataFile = new File("Studentdatabase.csv");
                        FileWriter fw = new FileWriter("Studentdatabase.csv", true);
                        PrintWriter myFileWriter = new PrintWriter(fw);//,append:true doesnt work             //file writer to new file
                        if (dataFile.createNewFile()) {
                            System.out.println("File created");
                        } else {
                            System.out.println("This file already exists");
                        }
                        myFileWriter.append(studentName + ",");                  //variables to write to file
                        myFileWriter.append(studentYear + ",");
                        myFileWriter.println(studentGpa + "\n");

                        myFileWriter.close();                           //close file writer
                    } catch (Exception myEx) {
                        System.out.println("Error");
                        myEx.printStackTrace();
                    }
                } else {
                    System.out.println("Enter missing information to write to file.");
                }
            } else if (response.equals("6")) {
                ArrayList<String> data = readDatabase("Studentdatabase.csv");
                int size = data.size();
                int x = 0;
                for (String line : data) {
                    studentNames.add(extractData(line, 0));
                    schoolYear.add(extractData(line, 1));
                    studentGPA.add(extractData(line, 2));
                    fullStudent.add("Student Name: " + studentNames.get(x) + " Student Year: " + schoolYear.get(x) + " Student GPA: " + studentGPA.get(x));
                    x++;
                    //System.out.println(fullStudent);
                }

                for (String line : fullStudent) {
                    System.out.println(line);
                    //x++;
                }
                //File myFile = new File("Student.txt");
                //String student;

                        /*File dataFile = new File(path);
                        String line = "";
                        readDatabase("Studentdatabase.csv");
                        try{
                            Scanner reader = new Scanner(dataFile);           //file reader to file
                            while(reader.hasNextLine()){
                                line = reader.nextLine();
                                arry.add(line);
                                //student = reader.nextLine();                //variable to store file lines
                                //System.out.println(student);                //print file lines
                            }

                        }catch(Exception myEx){
                            System.out.println("Error");
                        }*/
            } else if (response.equals("7")) {
                ArrayList<String> data = readDatabase("Studentdatabase.csv");
                int size = data.size();
                int x = 0;
                for (String line : data) {
                    studentNames.add(extractData(line, 0));
                    schoolYear.add(extractData(line, 1));
                    studentGPA.add(extractData(line, 2));
                }
                        myScanner.nextLine();
                System.out.println("Enter the Students Name to Search:");
                searchName = myScanner.nextLine();
                for(int i = 0; i < studentNames.size(); i++){
                    if(searchName.equals(studentNames.get(i))){
                        System.out.println(studentNames.get(i) + " " + schoolYear.get(i) + " " + studentGPA.get(i));
                    }
                }
            } else if (response.equals("8")) {                //exit

            } else {
                System.out.println("Please enter a numeric selection between 1 and 5");
                myScanner.nextLine();
                System.out.println("Press Enter to Clear Terminal");
                myScanner.nextLine();
                clearTer();
            }

        } while (!response.equals("8"));

    }



            public static ArrayList<String> readDatabase(String path){
                File dataFile = new File(path);
                String line = "";
                ArrayList<String> arry = new ArrayList<String>();
                try{
                    Scanner reader = new Scanner(dataFile);
                    //reader.nextLine();
                    while(reader.hasNextLine()){
                        line = reader.nextLine();
                        //System.out.println(line);
                        arry.add(line);
                    }

                }catch (Exception myEx){
                    System.out.println("Error");
                }
                return arry;
            }

            private static void printData(ArrayList<String> data){
                for(String things : data){
                    System.out.println(things);
                }
            }
            private static String extractData(String line, int posit){
                String [] holder = line.split(",");
                return holder[posit];
            }

            //check if anything is missing. Report back what is Extra Credit 2 and 3
            public static int missingData(String name, String acYear, double gpa) {
                String[] questions = {"Students Name", "Students Academic Year", "Students GPA"};
                int countOfMissing = 0;                     //set count of missing to then increment by 1 to check missing data
                if (name.isEmpty()) {
                    System.out.println("It looks like you left " + questions[0] + " blank");    //lets user know what data they need to input in order to write to file
                    countOfMissing++;
                }
                if (acYear.isEmpty()) {
                    System.out.println("It looks like you left " + questions[1] + " blank");
                    countOfMissing++;
                }
                if (gpa < 0){
                    System.out.println("It looks like you left " + questions[2] + " blank");
                    countOfMissing++;
                }
                return countOfMissing;
            }

            //required method 3 - check that entries for AY and GPA are valid
            public static int validEntry(String year, double gpa){
                ArrayList<String> validAys = new ArrayList<String>();
                validAys.add("freshman");
                validAys.add("sophomore");
                validAys.add("junior");
                validAys.add("senior");

                double lower = 0.0;             //lower bound for gpa
                double upper = 4.0;             //upper bound for gpa

                if(!validAys.contains(year) && (gpa< lower || gpa > upper)){            //if year and gpa invalid..
                    System.out.println("The Year provided is invalid. The GPA appears to be outside the bounds of 0.0 and 4.0");
                    return 1;
                }else if(!validAys.contains(year)){                             //if user does not input valid ay
                    System.out.println("The Year provided is invalid.");
                    return 1;
                }else if(gpa< lower || gpa > upper){
                    System.out.println("The GPA appears to be outside the bounds of 0.0 and 4.0");  //if gpa lower or higher than bounds display invalid message
                    return 1;
                }
                return 0;
            }

            //extra credit option 1
            public static void clearTer(){              //clear terminal method
                System.out.println("\033[H\033[2J");
                System.out.flush();
            }


            //required method 2
            private static void mainMenu(){             //main menu method
                System.out.println("1. Enter Students Name");
                System.out.println("2. Enter Students Academic Year");
                System.out.println("3. Enter Students GPA");
                System.out.println("4. Display Students Info");
                System.out.println("5. Write Data to File");            //new for week2
                System.out.println("6. Read Data From File");           //new for week2
                System.out.println("7. Search By Name");
                System.out.println("8. Exit");
            }

}

