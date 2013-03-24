package org.thinkbigthings.katas.palindrome;

public class DefaultPalindromeChecker implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String input)
    {

        // only need to loop over half of the string because second half is checked at the same time as the first
        // also can break if you detect it's not a palindrome in which case don't need to check the rest
        int halfLength = input.length()/2;
        boolean p = true;
        for(int i=0; i < halfLength; i++)
        {
            if(input.charAt(i) != input.charAt(input.length()-1-i))
            {
                p = false;
                break;
            }
        }
        return p;
    }
    
}
