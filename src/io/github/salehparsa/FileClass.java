package io.github.salehparsa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by saleh on 9/19/16.
 */
public class FileClass {
    public void FileReader()
    {
        String[] value = new String[70520];
        String[] time = new String[70520];
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
                value[i] = regex [1]; // shows 109.09 109.095 109.093 FXCM
                time[i] = line.replaceAll(regex[1], ""); // shows 00:00:00 00:00
                i++;
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
