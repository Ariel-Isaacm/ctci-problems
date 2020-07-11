package LinkedLists;

import java.util.HashSet;
import java.util.List;

public class LinkedLists {


    //2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
    //FOLLOW UP
    //How would you solve this problem if a temporary buffer is not allowed?
    public ListNode removeDups(ListNode list) {
        ListNode head = list;
        //solution with buffer O(n) O(n)
        //        HashSet<Integer> nums = new HashSet<Integer>();
        //        ListNode previous = null;
        //        while(list != null){
        //            if(nums.contains(list.val)){
        //                previous.next = list.next;
        //            } else {
        //                nums.add(list.val);
        //                previous = list;
        //            }
        //                list = list.next;
        //        }

        //solution without buffer O(n^2) O(1)
        while (list != null) {
            helperRemoveDups(list.val, list.next, list);
            list = list.next;
        }
        return head;
    }

    private void helperRemoveDups(int target, ListNode node, ListNode previous) {
        while (node != null) {
            if (node.val == target) {
                previous.next = node.next;
            } else {
                previous = node;
            }
            node = node.next;
        }
    }

    //2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
    public ListNode kthElement(ListNode node, int kth) {
        ListNode slow = node;
        ListNode fast = node;
        for (int i = 0; i < kth; i++) {
            fast = fast.next; // assuming that the list is big enough to hold more than kth elements
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    //2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (Le., any node but
    //the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    //that node.
    public boolean deleteMiddleNode(ListNode node) {
        if (node == null || node.next == null) return false;
        ListNode nextN = node.next;
        node.val = nextN.val;
        node.next = nextN.next;
        return true;
    }

    //2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    //before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
    //to be after the elements less than x (see below). The partition element x can appear anywhere in the
    //"right partition"; it does not need to appear between the left and right partitions.
    public ListNode createPartition(ListNode node, int partition) {
        if (node == null) return null;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val < partition) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

}
