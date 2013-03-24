package org.thinkbigthings.katas.stringreverse;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StringReverserTest {

    private String input;
    private String output;

    private StringReverser simpleReverser      = new SimpleStringReverser();
    private StringReverser recursiveReverser   = new RecursiveStringReverser();
    private StringReverser arraysReverser      = new StringReverserArrays();
    private StringReverser collectionsReverser = new HeavyStringReverser();
    
    @Parameterized.Parameters
    public static Collection getTestArgs() {
        return Arrays.asList(new Object[][] {
            { "Jason", "nosaJ"},
            { "", ""},
            { "a", "a"},
            { null, null}
        });
    };
    
    public StringReverserTest(String in, String out)
    {
        input = in;
        output = out;
    }


    @Test
    public void testStringReverseStringBuffer()
    {
        Assert.assertEquals("output should be reversed input", output, simpleReverser.reverse(input));
    }
    
    @Test
    public void testStringReverseCollectionsHeavy()
    {
        Assert.assertEquals("output should be reversed input", output, collectionsReverser.reverse(input));

    }
    
    @Test
    public void testStringReverseArrays()
    {
        Assert.assertEquals("output should be reversed input", output, arraysReverser.reverse(input));

    }
    
    @Test
    public void testStringRecursiveReversive()
    {
        Assert.assertEquals("output should be reversed input", output, recursiveReverser.reverse(input));
    }
}