package com.priyakdey.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class SimplifyDirectoryPath {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String s : paths) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder buf = new StringBuilder();
        while (!stack.isEmpty()) {
            // Insert elements in the correct order
            buf.insert(0, "/" + stack.pop());
        }

        return buf.toString();
    }

}
