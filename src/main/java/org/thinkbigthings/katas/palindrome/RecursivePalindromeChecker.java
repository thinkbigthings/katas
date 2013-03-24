package org.thinkbigthings.katas.palindrome;

public class RecursivePalindromeChecker implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String input)
    {
        // base case for recursion:
        // length 1 for odd-length starting strings, length 0 for even-length starting strings
        if(input.length() == 1 || input.isEmpty()) {
            return true;
        }

        if(input.charAt(0) == input.charAt(input.length()-1)) {
            return isPalindrome(input.substring(1,input.length()-1));
        }   

        return false;
    }
    
}
