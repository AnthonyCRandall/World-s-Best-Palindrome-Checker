
package worldsbestpalindromechecker;
import java.util.Random;
import java.util.Scanner;

public class WorldsBestPalindromeChecker {
    
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Have the user enter a string
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
        
        // Test different lengths and compositions
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

    public static boolean isPalindrome(String s) {
        
        //Convert string to lowercase and remove unwanted non-alphanumeric characters
        String updatedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = updatedString.length() - 1;
        
        while(left < right){
            // Check characters from both ends of the string
            if (updatedString.charAt(left) != updatedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    //Create a method to generate a random string 
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+{}|:\\\"<>?-=[]\\\\;',./";
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
