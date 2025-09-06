package LinkedList.OneDLinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Deletion {
//    Delete the head of LL
    public static Node deleteHead(Node head){
        if(head==null){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    //  Delete the tail of LL
    public static Node deleteTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    //  Delete the kth Position from the LL
    public static Node deleteKPos(Node head, int pos){
        if(head==null){
            return null;
        }
        if(pos==1){
            Node temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int count = 0;
        while(temp!=null){
            if(count==(pos)){
                prev.next = prev.next.next;
                temp.next = null;
                return head;
            }else{
                count++;
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
    // write a function to delete the element with given value
    public static Node deleteElement(Node head, int element){
        if(head==null){
            return null;
        }
        if(head.data==element){
            Node temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==element){
                prev.next = temp.next;
                temp.next = null;
                return head;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head = deleteElement(head, 3);
        printList(head);
    }

}
