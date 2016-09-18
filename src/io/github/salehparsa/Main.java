package io.github.salehparsa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String[] splitted = new String[70520];
        String[] timer = new String[70520];
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("text.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            //Read File Line By Line
            int i =0;
            while ((line = br.readLine()) != null)   {
                //Regex to split time and values
                String [] regex = line.split("^([0-1]?[0-9]|2[0-9]):[0-9][0-9]:[0-9][0-9]([a-zA-Z0-9_ ])[0-9][0-9]:[0-9][0-9]");
                splitted[i] = regex [1]; // shows 109.09 109.095 109.093 FXCM
                timer[i] = line.replaceAll(regex[1], ""); // shows 00:00:00 00:00
                i++;
            }
            //Close the input stream
            in.close();

            System.out.println(splitted[0]);
            System.out.println(timer[0]);
            System.out.println(splitted[1]);
            System.out.println(timer[1]);


        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
