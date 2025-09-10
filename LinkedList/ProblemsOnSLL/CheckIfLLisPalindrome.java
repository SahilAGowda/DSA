package LinkedList.ProblemsOnSLL;

import java.util.Stack;
 class ListNode {
    int val;
     ListNode next;
     
     ListNode(int val) { this.val = val; }
}

public class CheckIfLLisPalindrome {
    /*
     * Given the head of a singly linked list, return true if it is a palindrome or
     * false otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     * 
     * 
     * Input: head = [1,2]
     * Output: false
     * 
     * 
     * Constraints:
     * 
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     * 
     * 
     * Follow up: Could you do it in O(n) time and O(1) space?
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;// even len
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        // first find the middle
        // reverse the element from the middle
        // compare

        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode second = reverse(middle.next);// m2 second
        ListNode right = second; // traverse ke liye [pointer]
        while (right != null) {
            if (right.val != left.val) {
                middle.next = reverse(second);
                return false;
            }
            right = right.next;
            left = left.next;
        }
        middle.next = reverse(second);
        return true;

    }
    public static boolean isPalindromeBrute(ListNode head) {
        if(head==null || head.next == null)return true;
        Stack<Integer>st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.val!=st.peek()){
                return false;
            }else{
                st.pop();
            }
            temp = temp.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeBrute(head));
    }
}
