package LinkedList.ProblemsOnSLL;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FindTheStartingOfLoop {
    /*
     * Given the head of a linked list, return the node where the cycle begins. If
     * there is no cycle, return null.
     * 
     * There is a cycle in a linked list if there is some node in the list that can
     * be reached again by continuously following the next pointer. Internally, pos
     * is used to denote the index of the node that tail's next pointer is connected
     * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
     * a parameter.
     * 
     * Do not modify the linked list.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * second node.
     * Example 2:
     * 
     * 
     * Input: head = [1,2], pos = 0
     * Output: tail connects to node index 0
     * Explanation: There is a cycle in the linked list, where tail connects to the
     * first node.
     * Example 3:
     * 
     * 
     * Input: head = [1], pos = -1
     * Output: no cycle
     * Explanation: There is no cycle in the linked list.
     * 
     * 
     * Constraints:
     * 
     * The number of the nodes in the list is in the range [0, 104].
     * -105 <= Node.val <= 105
     * pos is -1 or a valid index in the linked-list.
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        HashMap<ListNode, Integer> hm = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (hm.containsKey(temp)) {
                return temp;
            } else {
                hm.put(temp, 1);
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode detectCycleOPtimaListNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);

        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode ans = detectCycle(head);

        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println("No cycle");
        }
    }

}
