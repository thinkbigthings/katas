
package org.thinkbigthings.katas.anagram.primes;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.thinkbigthings.katas.primes.PrimeSearch;
import org.thinkbigthings.katas.primes.PrimeSearchSieveOfEratosthenes;

public class PrimeSearchTest {


//    @Test
//    public void calculateBigIntegerPrimes() {
//
//        PrimeNumbers prime = new PrimeNumbers();
//
//        List<BigInteger> knownPrimes = Arrays.asList(new BigInteger("2"), new BigInteger("3"));
//        List<BigInteger> foundPrimes = prime.getAllPrimes(new BigInteger("4"));
//        Assert.assertEquals("found number of primes was incorrect", knownPrimes.size(), foundPrimes.size());
//        Assert.assertEquals("found primes are not correct", knownPrimes, foundPrimes);
//    }

    @Test
    public void calculatePrimes() {

        PrimeSearch<Integer> sieve = new PrimeSearchSieveOfEratosthenes();

        List<Integer> knownPrimes = Arrays.asList(2,3,5,7,11,13,17,19);
        List<Integer> foundPrimes = sieve.findPrimesBelow(20);

        Assert.assertEquals(knownPrimes, foundPrimes);
    }

//    @Test
//    public void isBigIntegerPrime() {
//
//        PrimeNumbers prime = new PrimeNumbers();
//
//        Assert.assertTrue(prime.isPrime(new BigInteger("11")));
//        Assert.assertTrue(prime.isPrime(new BigInteger("49999991")));
//
//        Assert.assertFalse(prime.isPrime(new BigInteger("111")));
//        Assert.assertFalse(prime.isPrime(new BigInteger("49999999")));
//    }

}
