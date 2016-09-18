package io.github.salehparsa;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by saleh on 9/19/16.
 */
public class FileClass {
    File value = new File("value.txt");
    File timeFile = new File("time.txt");
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
        Occurrence occurrence = new Occurrence ();
        occurrence.Occurance(value);
        ArrayToFile(time);
    }
    public void FileWriter(Set<String> set)
    {
       // String content = new String();
        try (FileOutputStream fop = new FileOutputStream(value)) {
            // if file doesn't exists, then create it
            if (!value.exists()) {
                value.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(fop);
            Iterator it = set.iterator();
            for (String s: set){
                osw.write(it.next() + "\n");
            }
            osw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ArrayToFile(String [] arr)
    {
        // String content = new String();
        try (FileOutputStream fop = new FileOutputStream(timeFile)) {
            // if file doesn't exists, then create it
            if (!timeFile.exists()) {
                timeFile.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(fop);
            for (int i =0; i <arr.length ; i++){
                osw.write(arr[i]+ "\n");
            }
            osw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
