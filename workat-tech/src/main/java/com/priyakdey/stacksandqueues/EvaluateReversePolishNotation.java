package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class EvaluateReversePolishNotation {

    int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        int rhs, lhs;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    rhs = stack.pop();
                    lhs = stack.pop();
                    stack.push(lhs + rhs);
                    break;
                case "-":
                    rhs = stack.pop();
                    lhs = stack.pop();
                    stack.push(lhs - rhs);
                    break;
                case "*":
                    rhs = stack.pop();
                    lhs = stack.pop();
                    stack.push(lhs * rhs);
                    break;
                case "/":
                    rhs = stack.pop();
                    lhs = stack.pop();
                    stack.push(lhs / rhs);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
