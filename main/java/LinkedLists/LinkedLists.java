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

    //2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
    //digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    //function that adds the two numbers and returns the sum as a linked list.
    public ListNode sumLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode ans = null;
        int val1 = 0;
        int val2 = 0;
        int prev = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int newVal;
            if (val1 + val2 + prev > 9) {
                newVal = (val1 + val2 + prev) % 10;
                prev = 1;
            } else {
                newVal = val1 + val2 + prev;
                prev = 0;
            }

            curr.val = newVal;
            if (ans == null) ans = curr;
            curr.next = new ListNode();
            curr = curr.next;
            val1 = 0;
            val2 = 0;
        }
        if (prev > 0) {
            curr.val = prev;
        }
        return ans;
    }

    //2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
    public boolean isPalindrome(ListNode node) {
        ListNode reverse = reverseList(node);
        while (node != null) {
            if (node.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            node = node.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode node) {
        // ref https://github.com/Ariel-Isaacm/LeetCodeProblems/blob/master/LinkedList/ReverseLinkedList206.java
        ListNode head = null;
        while (node != null) {
            ListNode n = new ListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;

    }

    //2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
    // Note that the intersection is defined based on reference, not value.
    // That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second
    //linked list, then they are intersecting.
    public ListNode intersection(ListNode node1, ListNode node2) {
        HashSet<ListNode> seen = new HashSet<ListNode>();
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                if (seen.contains(node1)){
                    return node1;
                } else {
                    seen.add(node1);
                }
                node1 = node1.next;
            }
            if (node2 != null) {
                if (seen.contains(node2)){
                    return node2;
                } else {
                    seen.add(node2);
                }
                node2 = node2.next;
            }
        }

        return null;
    }

}
