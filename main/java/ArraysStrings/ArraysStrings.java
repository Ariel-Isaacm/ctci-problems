package ArraysStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ArraysStrings {

    // isUnique: Implement an algorithm to determine if a a string has all unique characters,
    // what would you do if you cannot use additional data structure?
//    public boolean isUnique(String input) {
//        // O(nlogn) time complexity
//        if (input.length() < 2) return true;
//        char[] chars = input.toCharArray();
//        Arrays.sort(chars);
//        char prev = chars[0];
//        for (int i = 1; i < chars.length; i++) {
//            if (prev == chars[i]) {
//                return false;
//            }
//            prev = chars[i];
//        }
//        return true;
//
//        //
//    }

    public boolean isUnique(String input) {
        // O(n) time complexity O(n) space complexity
        if (input.length() < 2) return true;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.charAt(i))) {
                return false;
            }
            set.add(input.charAt(i));
        }
        return true;
    }

    //Check Permutation: Given two strings, write a method to decide if one is a permutation oof the other
    public boolean checkPermutation(String a, String b) {
        // O(n) time complexity O(1) space complexity
        if (a.length() != b.length()) return false;
        int xor = 0;
        for (int i = 0; i < a.length(); i++) {
            xor ^= a.charAt(i) ^ b.charAt(i);
        }
        return xor == 0;
    }

    //URLify:
    //Write a method to replace all spaces in a string with '%20' You may assume that the string has sufficient space at the end
    //to hold the additional characters, and that you are given the true length of the string.(Note:
    //If implementing in Java, please use a character array so that you can perform this operation in place.)
    public String URLify(char[] charArray) {
        // O(n) space and time complexity
        LinkedList<Character> root = new LinkedList<Character>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                root.add('%');
                root.add('2');
                root.add('0');
            } else if (Character.isLetter(charArray[i])) {
                root.add(charArray[i]);
            }
        }
        for (int i = 0; i < root.size(); i++) {
            charArray[i] = root.get(i);
        }
        return String.valueOf(charArray);
    }


//    Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
//    A palindrome is a word or phrase that is the same forwards and backwards.
//    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    public boolean palindromePermutation(String s) {
        // O(n) time, O(1) space since we will store a collection depending on the dictionary of letters available

        // should  we ignore whitespaces?
        s = s.replaceAll(" ", "");
        boolean isEven = s.length() % 2 == 0;
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();  // this could be replace with an array
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (letters.containsKey(current)) {
                int times = letters.get(current) + 1;
                letters.put(current, times);
            } else {
                letters.put(current, 1);
            }
        }

        if (isEven) {
            // all of the letters should be even
            for (Integer times : letters.values()) {
                if (times % 2 != 0) {
                    return false;
                }
            }
        } else {
            boolean oddFound = false;
            for (Integer times : letters.values()) {
                if (times % 2 != 0) {
                    if (!oddFound) {
                        oddFound = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
