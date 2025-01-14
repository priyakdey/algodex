package com.priyakdey.algoexpert.recursion;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class PhoneNumberNmemonics {

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        StringBuilder buf = new StringBuilder();
        ArrayList<String> acc = new ArrayList<>();
        Map<Character, String> keypad = Map.of(
                '0', "0",
                '1', "1",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"

        );
        generatePhoneNumberMnemonics(phoneNumber,0, buf, acc, keypad);
        return acc;
    }


    private void generatePhoneNumberMnemonics(String phoneNumber, int index,
                                              StringBuilder buf,
                                              ArrayList<String> acc,
                                              Map<Character, String> keypad) {
        if (index == phoneNumber.length()) {
            acc.add(buf.toString());
            return;
        }

        String mapping = keypad.get(phoneNumber.charAt(index));

        for (char ch : mapping.toCharArray()) {
            buf.append(ch);
            generatePhoneNumberMnemonics(phoneNumber, index + 1, buf, acc,
                    keypad);
            buf.deleteCharAt(buf.length() - 1);
        }
    }
}
