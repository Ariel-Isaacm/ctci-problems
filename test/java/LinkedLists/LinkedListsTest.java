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
