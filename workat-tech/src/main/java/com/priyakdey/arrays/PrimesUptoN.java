package com.priyakdey.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PrimesUptoN {

    List<Integer> primesUptoN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("invalid argument");
        }
        if (n < 2) {
            return List.of();
        }

        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
