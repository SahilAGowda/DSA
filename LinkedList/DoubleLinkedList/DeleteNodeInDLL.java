package LinkedList.DoubleLinkedList;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
    }
}
public class DeleteNodeInDLL {
    public static Node deleteHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    } 

    public static Node deleteTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        Node prev = tail.prev;
        prev.next = null;
        tail.prev = null;
        return head;
    }

    public static Node deleteKPos(Node head,int pos){
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==pos)break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node front = temp.next;
        if(prev==null && front==null){
            return null;
        }else if(prev==null){
            return deleteHead(head);
        }else if(front==null){
            return deleteTail(head);
        }else{
            prev.next = front;
            front.prev = prev;
            temp.next = null;
            temp.prev = null;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head = deleteKPos(head, 4);
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
