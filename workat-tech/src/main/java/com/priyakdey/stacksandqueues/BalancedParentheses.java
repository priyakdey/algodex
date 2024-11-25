package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class BalancedParentheses {

    boolean isBalancedParentheses(String str) {
        Map<Character, Character> table = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (table.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != table.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
