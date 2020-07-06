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
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next = new ListNode(6);
        solution.removeDups(listNode);
    }

    @Test
    void testKthElement() {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next = new ListNode(6);
        assertEquals(5, solution.kthElement(listNode, 5).val);
    }
}