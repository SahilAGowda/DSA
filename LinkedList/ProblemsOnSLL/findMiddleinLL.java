package LinkedList.ProblemsOnSLL;
class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}
public class findMiddleinLL {
    /*
     * Given the head of a singly linked list, return the middle node of the linked
     * list.
     * If there are two middle nodes, return the second middle node.
     * 
     */
    public static ListNode findMiddleBrute(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp=head;
        int middle = (len/2)+1;
        while(temp!=null){
            middle--;
            if(middle==0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    // Optimal Tortoise Hare Algorithm
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next; //1 step
            fast = fast.next.next; // 2 step
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
        ListNode middle = findMiddle(head);
        System.out.println(middle.data);
        ListNode middle2 = findMiddleBrute(head);
        System.out.println(middle2.data);
        
    }
}
