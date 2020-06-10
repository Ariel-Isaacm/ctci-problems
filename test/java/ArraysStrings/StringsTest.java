package ArraysStrings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    private static ArraysStrings solution;
    @BeforeAll
    public static void setUp(){
        solution = new ArraysStrings();
    }

    @Test
    public void testIsUnique(){
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
}