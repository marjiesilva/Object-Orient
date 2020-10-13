package com.company;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File myFile = new File("/Users/Marjie/IdeaProjects/filePractice/src/test.txt");
        String line;


        try{
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                System.out.println(line);
            }

        }catch(Exception e){
            System.out.println("error");
        }
    }




}
