package org.example;

import java.util.function.Predicate; // needed to use Predicate

import java.util.ArrayList;
import java.util.List;


public class LambdaLab{
	public static void main(String args[]){

		// Exercise #1 ******************************
		Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        //System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        //System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));
        // ******************************************

        // Exercise #2 ******************************
      	List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        // Define a predicate with a lambda to find call signs starting with "A"
        Predicate<String> startsWithA = s -> s.startsWith("A");

        // Pass the list and the predicate (the behavior) to our method
        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");
        // ******************************************


        // Exercise #3 ******************************
        
        // ******************************************

	}

	// A helper method to print the results of our filtering
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            // Use the predicate's test method to filter
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
}
