package ArraysStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class ArraysStrings {

    // 1.1 isUnique: Implement an algorithm to determine if a a string has all unique characters,
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

    boolean isUnique(String input) {
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

    // 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation oof the other
    boolean checkPermutation(String a, String b) {
        // O(n) time complexity O(1) space complexity
        if (a.length() != b.length()) return false;
        int xor = 0;
        for (int i = 0; i < a.length(); i++) {
            xor ^= a.charAt(i) ^ b.charAt(i);
        }
        return xor == 0;
    }

    // 1.3 URLify:
    //Write a method to replace all spaces in a string with '%20' You may assume that the string has sufficient space at the end
    //to hold the additional characters, and that you are given the true length of the string.(Note:
    //If implementing in Java, please use a character array so that you can perform this operation in place.)
    String URLify(char[] charArray) {
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


//    1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
//    A palindrome is a word or phrase that is the same forwards and backwards.
//    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    boolean palindromePermutation(String s) {
        // O(n) time, O(1) space since we will store a collection depending on the dictionary of letters available
        // should  we ignore whitespaces?
        s = s.replaceAll(" ", "").toLowerCase();
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

    // 1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
    //remove a character, or replace a character. Given two strings, write a function to check if they are
    //one edit (or zero edits) away.
    boolean oneWay(String s1, String s2) {
        // O(n) time O(1) space
        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        boolean differenceFound = false;

        String bigger, smaller;
        if (s1.length() > s2.length()) {
            bigger = s1;
            smaller = s2;
        } else {
            bigger = s2;
            smaller = s1;
        }

        int index1 = 0;
        int index2 = 0;
        while (index1 < bigger.length() && index2 < smaller.length()) {
            if (bigger.charAt(index1) == smaller.charAt(index2)) {
                index2++;
            } else {
                if (differenceFound) return false;
                differenceFound = true;
                if (bigger.length() == smaller.length()) {
                    index2++;
                }
            }
            index1++;
        }
        return true;
    }

    //1.6 String Compression: Implement a method to perform basic string compression using the counts
    //of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    //"compressed" string would not become smaller than the original string, your method should return
    //the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    public String stringCompression(String input) {
        if (input == null || input.length() < 1) return input;
        StringBuilder ans = new StringBuilder();
        char previous = input.charAt(0);
        int times = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == previous) {
                times++;
            } else {
                ans.append(previous).append(times);
                times = 1;
                previous = input.charAt(i);
            }
        }
        ans.append(previous).append(times);
        return ans.length() > input.length() ? input : ans.toString();
    }


    // 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    //bytes, write a method to rotate the image by 90 degrees. (an you do this in place?


    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
    //    // 1,2,3     7,4,1
    //    // 4,5,6     8,5,2
    //    // 7,8,9     9,6,3

    // +2,0, +1,+1, 0,+2
    // +1,+1, 0,0, -1,+1
    // -2,0, -1,-1, 0,-2

    // n=3
    // n-n    ,n-(n+2)| n-2     ,n-2     | n-n    ,n-1
    // n-2    ,n-2    | n-n     ,n-n    | n-(n+1),n-2
    // n-(n+2),n-n    | n-(n+1) ,n-(n+1)| n-n    ,n-(n+2)


    //1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //column are set to O.
    public int[][] zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        boolean[][] isProcessed = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && !isProcessed[i][j]) {
                    convertColumnsAndRows(matrix, isProcessed, i, j);
                }
            }
        }
        return matrix;
    }

    private void convertColumnsAndRows(int[][] matrix, boolean[][] processed, int i, int j) {
        for (int k = 0; k < matrix[j].length; k++) {
            if (!processed[i][k]) {
                matrix[i][k] = 0;
                processed[i][k] = true;
            }

        }
        for (int k = 0; k < matrix.length; k++) {
            if (!processed[k][j]) {
                matrix[k][j] = 0;
                processed[k][j] = true;
            }
        }
    }
}
