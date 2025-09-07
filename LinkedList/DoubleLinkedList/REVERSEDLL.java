package LinkedList.DoubleLinkedList;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
    }
}
public class REVERSEDLL {
    public Node reverse(Node head) {
        // code here
        if(head==null || head.next==null){
            return head;
        }
        Node last = null;
        Node cur = head;
        while(cur!=null){
            last = cur.prev;
            cur.prev = cur.next;
            cur.next = last;
            cur = cur.prev;
        }
        return last.prev;
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.prev = head.next.next.next;
        printList(head);
        REVERSEDLL obj = new REVERSEDLL();
        Node newHead = obj.reverse(head);
        printList(newHead);
    }
}
