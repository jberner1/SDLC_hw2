//Date:5-12-20
//Author: Jennifer Berner
//Module 2 SDLC Assignment
package deafault_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Poem_ {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Integer> map = new HashMap<String, Integer>(); //using HashMap
		
		Scanner txtFile= new Scanner(new File("poem.txt"));  //poem is in a text file
		while (txtFile.hasNext()) {
			String word = txtFile.next().replaceAll("[^a-zA-Z0-9 ]", ""); //removing punctuations etc.  
			if (map.containsKey(word)) {   // counting how many times a word occurs
				int count = map.get(word) + 1; // count goes up 1 if word already exist
				map.put(word,  count);	
			}
			else{
				map.put(word, 1);         // if the word count is one
			}
		}
		txtFile.close();  // closing the text file
		
		Set<Map.Entry<String, Integer>> set = map.entrySet(); // grabbing the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); // making the array list 
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() // sorting the array list
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) // allows for comparing 
            {
                return (b.getValue()).compareTo( a.getValue() ); // having it go in descending order 
            }
        } );

        for(Map.Entry<String, Integer> i:sortedList){  // printing the list
            System.out.println(i.getKey()+"="+i.getValue());
        }
	}
}
