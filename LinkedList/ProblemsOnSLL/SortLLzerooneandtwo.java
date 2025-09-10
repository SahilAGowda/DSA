package LinkedList.ProblemsOnSLL;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
public class SortLLzerooneandtwo {
    /*
     * Given the head of a linked list where nodes can contain values 0s, 1s, and 2s
     * only. Your task is to rearrange the list so that all 0s appear at the
     * beginning, followed by all 1s, and all 2s are placed at the end.
     * 
     * Examples:
     * 
     * Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
     * 
     * Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
     * Explanation: All the 0s are segregated to the left end of the linked list, 2s
     * to the right end of the list, and 1s in between. The final list will be:
     * 
     * Input: head = 2 → 2 → 0 → 1
     * 
     * Output: 0 → 1 → 2 → 2
     * Explanation: After arranging all the 0s, 1s and 2s in the given format, the
     * output will be:
     * 
     * Constraints:
     * 1 ≤ no. of nodes ≤ 106
     * 0 ≤ node->data ≤ 2
     */
    public static Node segregate(Node head) {
        // code here
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        // Traversal
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);
        Node newHead = segregate(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
