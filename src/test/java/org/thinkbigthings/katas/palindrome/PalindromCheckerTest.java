package org.thinkbigthings.katas.palindrome;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PalindromCheckerTest {

    private String input;
    private boolean expectInputPalindrome;
    
    private PalindromeChecker checkerRecursive = new RecursivePalindromeChecker();
    private PalindromeChecker checkerDefault = new DefaultPalindromeChecker();
    
    @Parameterized.Parameters
    public static Collection getTestArgs() {
        return Arrays.asList(new Object[][] {
            { "Jason", false},
            { "", true},
            { "a", true},
            { "ab", false},
            { "aabbaa", true},
            { "aab12baa", false},
            { "aab121baa", true},
            { "aabaa", true}
        });
    };
    
    public PalindromCheckerTest(String in, boolean p)
    {
        input = in;
        expectInputPalindrome = p;
    }

    @Test
    public void testPalindromeRecursive()
    {
        Assert.assertEquals("output should be reversed input", expectInputPalindrome, checkerRecursive.isPalindrome(input));
    }
    
    @Test
    public void testPalindrome()
    {
        Assert.assertEquals("output should be reversed input", expectInputPalindrome, checkerDefault.isPalindrome(input));
    }
    
}