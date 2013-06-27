package org.thinkbigthings.katas.anagram;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AnagramDetectorTest {

    private String input1;
    private String input2;
    private boolean expectAnagram;
    
    private AnagramDetector scanningDetector = new AnagramDetectorScanner();
    private AnagramDetector sortingDetector  = new AnagramDetectorSorting();
    private AnagramDetector freqDetector     = new AnagramDetectorFrequencyMap();
    
    @Parameterized.Parameters
    public static Collection getTestArgs() {
        return Arrays.asList(new Object[][] {
            { "jason", "josan", true},
            { "", "", true},
            { "a", "a", true},
            { "ab", "abc", false},
            { "check this check", "check check this", true},
            { "check this check", "check check this2", false}
        });
    };
    
    public AnagramDetectorTest(String s1, String s2, boolean isAnagram)
    {
        input1 = s1;
        input2 = s2;
        expectAnagram = isAnagram;
    }

    @Test
    public void testAnagramDetector()
    {
        Assert.assertEquals("Should detect anagrams", expectAnagram, scanningDetector.isAnagram(input1, input2));
        Assert.assertEquals("Should detect anagrams", expectAnagram, sortingDetector.isAnagram(input1, input2));
        Assert.assertEquals("Should detect anagrams", expectAnagram, freqDetector.isAnagram(input1, input2));
    }

}