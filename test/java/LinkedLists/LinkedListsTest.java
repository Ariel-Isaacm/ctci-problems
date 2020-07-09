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

    @Test
    void testDeleteMiddleNode() {
//        a->b->c->d->e->f
        ListNode listNode = new ListNode('a');
        listNode.next = new ListNode('b');
        ListNode cNode = listNode.next.next = new ListNode('c');
        listNode.next.next.next = new ListNode('d');
        listNode.next.next.next.next = new ListNode('e');
        listNode.next.next.next.next.next = new ListNode('f');
        solution.deleteMiddleNode(cNode);
        int size = 0;
        while (listNode != null) {
            size++;
            listNode = listNode.next;
        }
        assertEquals(5, size);
    }
}