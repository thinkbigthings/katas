
package org.thinkbigthings.katas.primes;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Maximum array index is Integer.MAX_INT,
 * but you generally reach a memory limit long before the logical limit.
 * The maximum size of an array depends physically on the size of the array type
 * byte  = 1 byte => max  2 Gb data
 * short = 2 byte => max  4 Gb data
 * int   = 4 byte => max  8 Gb data
 * long  = 8 byte => max 16 Gb data
 */
public class PrimeSearchSieveOfEratosthenes implements PrimeSearch<Integer> {

    @Override
    public List<Integer> findPrimesBelow(Integer max) {

      if(max <= 1 || max == Integer.MAX_VALUE) {
         throw new IllegalArgumentException("require 1 < argument < Integer.MAX_VALUE");
      }

      // max+1 is here because of using the index as the number
      boolean[] primes = new boolean[max+1];
      Arrays.fill(primes, true);
      List<Integer> foundPrimes = new LinkedList<>();
      for(int p = 2; p <= max; p++) {
         if(primes[p]) {
            foundPrimes.add(p);
            int n = p + p;
            while(n <= max) {
               primes[n] = false;
               n += p;
            }
         }
      }
      return foundPrimes;
   }

}