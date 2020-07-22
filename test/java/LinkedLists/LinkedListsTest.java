package LinkedLists;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {

    private static LinkedLists solution;

    @BeforeAll
    static void setUp() {
        solution = new LinkedLists();
    }


    @Test
    void testRemoveDups() {
        ListNode listNode = createListNodes(3, 5, 6, 3, 6, 6);
        solution.removeDups(listNode);
    }

    @Test
    void testKthElement() {
        ListNode listNode = createListNodes(3, 5, 6, 3, 6, 6);
        assertEquals(5, solution.kthElement(listNode, 5).val);
    }

    @Test
    void testDeleteMiddleNode() {
//        a->b->c->d->e->f
        ListNode listNode = createListNodes('a', 'b', 'c', 'd', 'e', 'f');
        solution.deleteMiddleNode(listNode.next.next);
        int size = 0;
        while (listNode != null) {
            size++;
            listNode = listNode.next;
        }
        assertEquals(5, size);
    }

    @Test
    void testCreatePartition() {
        solution.createPartition(createListNodes(3, 5, 8, 5, 10, 2, 1), 5);
    }

    @Test
    void testSumLists() {
        ListNode listNode = solution.sumLists(createListNodes(7, 1, 6), createListNodes(5, 9, 2));
        assertEquals(2, listNode.val);
        assertEquals(1, listNode.next.val);
        assertEquals(9, listNode.next.next.val);
    }

    @Test
    void testIsPalindrome() {
        assertFalse(solution.isPalindrome(createListNodes(0, 1, 2, 4, 0)));
        assertTrue(solution.isPalindrome(createListNodes(0, 1, 2, 1, 0)));
    }

    @Test
    void testLoopDetection() {
        ListNode head = createListNodes('A', 'B', 'C', 'D', 'E');
        ListNode corrupt = head.next.next;
        ListNode tail = head;
        while (true) {
            tail = tail.next;
            if (tail.next == null) {
                tail.next = corrupt;
                break;
            }
        }

        assertEquals(corrupt, solution.loopDetection(head));

    }

    ListNode createListNodes(int... vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;

        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
        }
        return head;
    }
}
