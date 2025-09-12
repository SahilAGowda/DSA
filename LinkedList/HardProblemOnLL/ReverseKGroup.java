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
public class ReverseKGroup {
    /*
     * Given the head of a linked list, reverse the nodes of the list k at a time,
     * and return the modified list.
     * 
     * k is a positive integer and is less than or equal to the length of the linked
     * list. If the number of nodes is not a multiple of k then left-out nodes, in
     * the end, should remain as it is.
     * 
     * You may not alter the values in the list's nodes, only nodes themselves may
     * be changed.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     * Example 2:
     * 
     * 
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     * 
     * 
     * Constraints:
     * 
     * The number of nodes in the list is n.
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     * 
     * 
     * Follow-up: Can you solve the problem in O(1) extra memory space?
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    public static ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null && k > 1) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // Reach the first kthNode do the traversal
        // preserve the next Node
        // point the next node to null
        // reverse the node

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode KthNode = findKthNode(temp, k);
            if (KthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;
            ListNode reverseHead = reverse(temp);
            if (head == temp) {
                head = KthNode;
            } else {
                if (prev != null)
                    prev.next = reverseHead;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode newHead = reverseKGroup(head, k);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
