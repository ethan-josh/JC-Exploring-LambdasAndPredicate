# Name: Ethan Joshua Camingao
## Exploring Java Lamdas and Predicate

---

### Exercise 1: The "New Way" - A Simple Lambda Expression

**Code to run:**
```
import java.util.function.Predicate;

public class LambdaLab {
    public static void main(String[] args) {
        // Create the same Predicate using a lambda expression.
        Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));
    }
}
```
**Predicted Output:**
```
Is 'short' long? false
Is 'This is a very long string' long? true
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-LambdasAndPredicate/blob/main/images/Ex1.png"/>

**Explanation:**

`s`: This is the parameter for the test method. Java knows its type is String because we declared the Predicate<String>.

`->`: The arrow token separates the parameter(s) from the body of the expression.

`s.length() > 10`: This is the implementation of the method. Since it's a single expression that evaluates to a boolean, Java automatically understands it as the return value. No return keyword or curly braces {} are needed.

---

### Exercise 3: Using Predicates to Filter a List

**Code to run:**
```
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaLab {
    
    // A helper method to print the results of our filtering
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            // Use the predicate's test method to filter
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println(); // Add a blank line for readability
    }

    public static void main(String[] args) {
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
    }
}
```
**Predicted Output:**
```
--- Call signs starting with 'A' ---
Alpha
Archangel
Bravo
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-LambdasAndPredicate/blob/main/images/Ex2.png"/>

**Explanation:**

We passed our startsWithA predicate into the filterAndPrint method. Inside the loop, the line if `(predicate.test(item))` executes the lambda's logic `(s -> s.startsWith("A"))` for each call sign. 
This makes our filterAndPrint method incredibly reusable—we can now pass any string-testing logic to it without changing the method itself.

---

### Exercise 4: Chaining Predicates (and, negate)

**Code to run:**
```
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaLab {
    // Re-using the filterAndPrint method from the previous exercise
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;
        
        // Let's find call signs that start with 'A' AND have a length > 5
        Predicate<String> complexCondition = startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, complexCondition, "Starts with 'A' AND length > 5");
        
        // Now let's find call signs that do NOT start with 'A'
        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "Does NOT start with 'A'");
    }
}
```
**Predicted Output:**
```
--- Starts with 'A' AND length > 5 ---
Archangel
Avenger

--- Does NOT start with 'A' ---
Bravo
Echo

```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-LambdasAndPredicate/blob/main/images/Ex3.png"/>

**Explanation:**

`predicate1.and(predicate2)` creates a new Predicate that returns true only if both original predicates return true.

`predicate.negate()` creates a new Predicate that returns the opposite boolean value of the original.