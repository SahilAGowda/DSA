package LinkedList.ProblemsOnSLL;

 class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class SortLL {
    /*
     * Given the head of a linked list, return the list after sorting it in
     * ascending order.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [4,2,1,3]
     * Output: [1,2,3,4]
     * Example 2:
     * 
     * 
     * Input: head = [-1,5,3,4,0]
     * Output: [-1,0,3,4,5]
     * Example 3:
     * 
     * Input: head = []
     * Output: []
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null)
            temp.next = l1;
        if (l2 != null)
            temp.next = l2;

        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        // find the middle
        // cut the connections divide into left and right half
        // merge
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode newHead = sortList(head);
        ListNode temp = newHead;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
