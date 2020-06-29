package ArraysStrings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    private static ArraysStrings solution;

    @BeforeAll
    static void setUp() {
        solution = new ArraysStrings();
    }

    @Test
    void testIsUnique() {
        assertTrue(solution.isUnique("abc"));
        assertFalse(solution.isUnique("acc"));
        assertTrue(solution.isUnique("aqc"));
        assertFalse(solution.isUnique("aaa"));
    }

    @Test
    void testCheckPermutation() {
        assertTrue(solution.checkPermutation("abc", "bca"));
        assertTrue(solution.checkPermutation("abc", "bac"));
        assertTrue(solution.checkPermutation("abc", "acb"));
        assertTrue(solution.checkPermutation("abc", "abc"));
        assertFalse(solution.checkPermutation("abc", "abcx"));
        assertFalse(solution.checkPermutation("abc", "iop"));
        assertFalse(solution.checkPermutation("abc", "abr"));
    }

    @Test
    void testUrlify() {
        assertEquals("Mr%20John%20Smith", solution.URLify(new char[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', 0, 0, 0, 0}));
    }

    @Test
    void testPalindromePermutation() {
        assertTrue(solution.palindromePermutation("Tact Coa"));
    }

    @Test
    void testOneWay() {
        assertTrue(solution.oneWay("pale", "ple"));
        assertTrue(solution.oneWay("pales", "pale"));
        assertTrue(solution.oneWay("pale", "bale"));
        assertFalse(solution.oneWay("pale", "bae"));
    }

    @Test
    void testStringCompression() {
        assertEquals("a2b1c5a3", solution.stringCompression("aabcccccaaa"));
    }

    @Test
    void testRotate() {
        solution.rotateMatrix(new int[][]{{1,2,3}, {4,5,6},{7,8,9}});
    }
}