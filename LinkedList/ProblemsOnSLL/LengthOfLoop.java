package LinkedList.ProblemsOnSLL;

import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LengthOfLoop {
    /*
     * Given the head of a linked list, determine whether the list contains a loop.
     * If a loop is present, return the number of nodes in the loop, otherwise
     * return 0.
     * 
     * Note: Internally, pos(1 based index) is used to denote the position of the
     * node that tail's next pointer is connected to. If pos = 0, it means the last
     * node points to null, indicating there is no loop. Note that pos is not passed
     * as a parameter.
     * 
     * Examples:
     * 
     * Input: pos = 2,
     * 
     * Output: 4
     * Explanation: There exists a loop in the linked list and the length of the
     * loop is 4.
     * Input: pos = 3,
     * 
     * Output: 3
     * Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 =
     * 3.
     * Input: pos = 0,
     * 
     * Output: 0
     * Explanation: There is no loop.
     * Constraints:
     * 1 ≤ number of nodes ≤ 105
     * 1 ≤ node->data ≤ 104
     * 0 ≤ pos < number of nodes
     * 
     * 
     */

    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }
        int count = 0;
        HashMap<Node, Integer> hm = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (hm.containsKey(temp)) {
                return count - hm.get(temp);
            } else {
                hm.put(temp, count++);
            }
            temp = temp.next;
        }
        return 0;
    }

    public static int lengthOfLoopOptimal(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;
        System.out.println(lengthOfLoop(head));
        System.out.println(lengthOfLoopOptimal(head));
    }
}
