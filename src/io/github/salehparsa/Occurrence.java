package io.github.salehparsa;

import java.util.*;

/**
 * Created by saleh on 9/19/16.
 */
public class Occurrence {
    public void Occurance (String [] arr)
    {
        int end = arr.length;
        List asList = Arrays.asList(arr);
        Set<String> set = new HashSet<String>();

        for(int i = 0; i < end; i++){
            set.add(arr[i]);
        }
        Iterator it = set.iterator();
        int j =0;
        for (String s: set) {
            System.out.println(it.next() + " " + Integer.toString(Collections.frequency(asList,s)));
        }
    }
}
