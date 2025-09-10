package LinkedList.ProblemsOnSLL;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNodefromLast {
    /*
     * Given the head of a linked list, remove the nth node from the end of the list
     * and return its head.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * Example 2:
     * 
     * Input: head = [1], n = 1
     * Output: []
     * Example 3:
     * 
     * Input: head = [1,2], n = 1
     * Output: [1]
     * 
     * 
     * Constraints:
     * 
     * The number of nodes in the list is sz.
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * 
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            if (n == 1)
                return head.next;
            else
                return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode del = slow.next;
        slow.next = del.next;
        del.next = null;
        return head;

    }

    // public static ListNode removeNthFromEnd(ListNode head, int n) {
    // if(head==null || head.next == null){
    // if(n==1)return head.next;
    // else return head;
    // }
    // int count=0;
    // ListNode temp = head;
    // while(temp!=null){
    // count++;
    // temp = temp.next;
    // }
    // int elem = count-n;
    // if(elem == 0){
    // return head.next;
    // }
    // temp = head;
    // while(temp!=null){
    // elem--;
    // if(elem==0){
    // break;
    // }
    // temp =temp.next;
    // }
    // ListNode del = temp.next;
    // temp.next = del.next;
    // del.next = null;
    // return head;
    // }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 2);
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
