package org.thinkbigthings.katas.primes;

import java.util.List;

public interface PrimeSearch<T extends Number> {
    List<T> findPrimesBelow(T max);
}
