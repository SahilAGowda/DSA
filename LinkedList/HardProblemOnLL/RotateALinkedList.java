package LinkedList.HardProblemOnLL;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

    /*
     * Given the head of a linked list, rotate the list to the right by k places.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     * Example 2:
     * 
     * 
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     * 
     * 
     * Constraints:
     * 
     * The number of nodes in the list is in the range [0, 500].
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     */
public class RotateALinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        // find the len
        // attached the right and the head;
        // traverse to the kth node
        // preserve the next node
        // and point that node to null
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        System.out.println(temp.val); // 2
        if (k % len == 0)
            return head;
        k = k % len;
        ListNode t2 = head;
        int steps = len - k;
        for (int i = 1; i < steps; i++) {
            t2 = t2.next;
        }

        temp.next = head;
        ListNode newHead = t2.next;
        t2.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode newHead = rotateRight(head, k);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
