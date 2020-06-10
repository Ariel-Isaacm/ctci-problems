package ArraysStrings;

import java.util.Arrays;
import java.util.HashSet;

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

        //
    }


    //Check Permutation: Given two strings, write a method to decide if one is a permutation oof the other
    public boolean checkPermutation(String a, String b){
        // O(n) time complexity O(1) space complexity
        if (a.length() != b.length()) return false;
        int xor = 0;
        for (int i = 0; i < a.length(); i++) {
            xor ^= a.charAt(i) ^ b.charAt(i);
        }
        return xor == 0;

    }

}
