package com.priyakdey.algoexpert.recursion;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class GenerateDivTags {

    // use two counters to keep track of amount of open and closed
    // tags. And use recursion.

    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> buffer = new ArrayList<>(numberOfTags * 2);
        ArrayList<String> tags = new ArrayList<>();
        generateDivTags(numberOfTags, 0, 0, buffer, tags);
        return tags;
    }

    private void generateDivTags(int numberOfTags, int open, int closed,
                                 ArrayList<String> buffer,
                                 ArrayList<String> tags) {
        if (open == closed) {
            if (closed == numberOfTags) {
                tags.add(String.join("", buffer));
            } else {
                buffer.add("<div>");
                generateDivTags(numberOfTags, open + 1, closed, buffer, tags);
                buffer.removeLast();
            }
        } else {
            if (open != numberOfTags) {
                buffer.add("<div>");
                generateDivTags(numberOfTags, open + 1, closed, buffer, tags);
                buffer.removeLast();
            }

            buffer.add("</div>");
            generateDivTags(numberOfTags, open, closed + 1, buffer, tags);
            buffer.removeLast();
        }
    }
}
