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

---