package com.priyakdey.algoexpert.recursion;

/**
 * @author Priyak Dey
 */
public class NthFibonacci {

    // F(n) = F(n - 1) + F(n -2)

    public static int getNthFib(int n) {
        int curr = 0, next = 1;
        while (n > 1) {
            int temp = next;
            next += curr;
            curr = temp;
            n--;
        }

        return curr;
    }

}
