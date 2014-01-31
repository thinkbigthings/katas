package org.thinkbigthings.katas.primes;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PrimeSearchTest {

    private final PrimeSearch<Integer> primeSearch = new PrimeSearchSieveOfEratosthenes();
    
    @Test(expected=IllegalArgumentException.class)
    public void testArgumentMustBeAbove1() throws Exception {
        primeSearch.findPrimesBelow(0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testArgumentMustBeBelowMax() throws Exception {
        primeSearch.findPrimesBelow(Integer.MAX_VALUE);
    }

    @Test
    public void calculateShouldFindSinglePrime() throws Exception {

        List<Integer> knownPrimes = Arrays.asList(2);
        List<Integer> foundPrimes = primeSearch.findPrimesBelow(2);

        Assert.assertEquals(knownPrimes, foundPrimes);
    }
    
    @Test
    public void calculateShouldFindBelow20() throws Exception {

        List<Integer> knownPrimes = Arrays.asList(2,3,5,7,11,13,17,19);
        List<Integer> foundPrimes = primeSearch.findPrimesBelow(20);

        Assert.assertEquals(knownPrimes, foundPrimes);
    }

}
