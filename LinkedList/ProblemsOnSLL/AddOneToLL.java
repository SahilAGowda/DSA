package LinkedList.ProblemsOnSLL;

public class AddOneToLL {
    /*
     * You are given a linked list where each element in the list is a node and have
     * an integer data. You need to add 1 to the number formed by concatinating all
     * the list node numbers together and return the head of the modified linked
     * list.
     * 
     * Note: The head represents the first element of the given array.
     * 
     * Examples :
     * 
     * Input: LinkedList: 4->5->6
     * Output: 457
     * 
     * Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.
     * Input: LinkedList: 1->2->3
     * Output: 124
     * 
     * Explanation: 1->2->3 represents 123 and when 1 is added it becomes 124.
     * Expected Time Complexity: O(n)
     * Expected Auxiliary Space: O(1)
     * 
     * Constraints:
     * 1 <= len(list) <= 105
     * 0 <= list[i] <= 9
     * 
     * 
     */

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head, prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static Node addOne(Node head) {
        // code here.
        // Brute on
        // reverse
        // add
        // reverse
        Node rev = reverse(head);
        Node temp = rev;
        int carry = 1;
        while (temp != null) {
            int val = temp.data + carry;
            if (val < 10) {
                temp.data = val;
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry != 0) {
            Node newNode = new Node(carry);
            rev = reverse(rev);
            newNode.next = rev;
            return newNode;
        }
        return reverse(rev);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node newHead = addOne(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
