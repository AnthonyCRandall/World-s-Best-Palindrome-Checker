
package worldsbestpalindromechecker;

import java.util.Random;
import java.util.Scanner;

public class WorldsBestPalindromeChecker {

    public static boolean isPalindrome(String s) { //Let's create a method to detect whether an input string is a palindrome or not
        
        //Convert string to lowercase and remove unwanted non-alphanumeric characters
        String updatedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0; //Instantiate a "left" variable to check the character at the left index
        int right = updatedString.length() - 1; //Instantiate a "right" variable to check the character at the right index
        
        while(left < right){ //While the two pointers arent overlaping
            if (updatedString.charAt(left) != updatedString.charAt(right)) {// Check characters from both ends of the string (compare the character at the left position to the character at the right position)
                return false; //If they are not equivalent, break the while loop
            }
            left++; //Move the left pointer to the right one index
            right--; //Move the right pointer to the left one index
        }
        return true; //If the characters match until the pointers overlap, the string is a palindrome, return true
    }
    
    //Create a method to generate a random string 
    public static String generateRandomString(int length) {
        Random random = new Random(); //Create a new random object called random
        StringBuilder randomString = new StringBuilder(length); //Create a string builder object called randomString
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+{}|:\\\"<>?-=[]\\\\;',./"; //These are the only acceptable characters that will be incorporated into the random string
        for (int i = 0; i < length; i++) { //Create a for loop to generate a string of n length
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            randomString.append(randomChar);
        }
        return randomString.toString();//Return the random string
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //Construct a new scanner
        
        System.out.print("Enter a string: ");
        
        // Read the input entered by the user
        String s = scanner.nextLine();
        
        // Check to see if the input string is a palindrome
        boolean isPalindrome = isPalindrome(s);
        
        // Display the result
        if (isPalindrome) {
            System.out.println(s + " is a palindrome.");
        } else {
            System.out.println(s +" is not a palindrome.");
        }
        
        // Close the scanner
        scanner.close();
        
        // Create an array and test different lengths and compositions
        int[] testLengths = {10, 100, 1000, 10000, 100000};
        
        System.out.println("\nTest Length (Characters)\tExecution Time (ns)");

        for (int length : testLengths) {
            String sb = generateRandomString(length);
            long startTime = System.nanoTime();
            boolean palindromeResult = isPalindrome(sb);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            
            System.out.println(length + "\t\t\t\t\t\t" + executionTime);
        }
    }        
}
    

