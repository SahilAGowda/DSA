package LinkedList.ProblemsOnSLL;

import java.util.List;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class reverseList {
    /*
     * Given the head of a singly linked list, reverse the list, and return the
     * reversed list.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     * Example 2:
     * 
     * 
     * Input: head = [1,2]
     * Output: [2,1]
     * Example 3:
     * 
     * Input: head = []
     * Output: []
     * 
     * 
     * Constraints:
     * 
     * The number of nodes in the list is the range [0, 5000].
     * -5000 <= Node.val <= 5000
     * 
     */

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        ListNode newHead = reverseList(head);
        ListNode temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
