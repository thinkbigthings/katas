package org.thinkbigthings.katas.primes;




import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.thinkbigthings.katas.primes.PrimeSearch;
import org.thinkbigthings.katas.primes.PrimeSearchSieveOfEratosthenes;

public class PrimeSearchTest {

    @Test
    public void calculatePrimes() {

        PrimeSearch<Integer> sieve = new PrimeSearchSieveOfEratosthenes();

        List<Integer> knownPrimes = Arrays.asList(2,3,5,7,11,13,17,19);
        List<Integer> foundPrimes = sieve.findPrimesBelow(20);

        Assert.assertEquals(knownPrimes, foundPrimes);
    }

}
