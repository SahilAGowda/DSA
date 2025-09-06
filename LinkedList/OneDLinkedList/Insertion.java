package LinkedList.OneDLinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Insertion {

    public static Node insertAtFront(Node head, int x) {
        // code here
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
    public static void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node insertionAtEnd(Node head,int x){
        if(head==null){
            return new Node(x);
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node newNode = new Node(x);
        temp.next = newNode;
        return head;
    }

    public static Node insertAtPos(Node head,int data,int pos){
        if(head==null){
            if(pos==1){
                return new Node(data);
            }else{
                return null;
            }
        }
        if(pos==1){
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }
        Node temp = head;
        int count=1;
        while(temp!=null){
            if(count==(pos-1)){
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }else{
                count++;
                temp = temp.next;
            }
        }
        return head;
    }
    // can u write for insertion of element before specified element
    public static Node insertBeforeElement(Node head,int data,int element){
        if(head==null){
            return null;
        }
        if(head.data==element){
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data==element){
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int x = 6;
        int pos = 3;
        Node head = new Node(5);
        
        // head=insertAtFront(head,1);
        // head = insertAtFront(head,2);
        // head= insertAtFront(head,3);
        // head = insertAtFront(head,4);
        printLL(insertionAtEnd(head, x));
        printLL(insertAtPos(head, x, pos));
        printLL(insertBeforeElement(head, x, 5));

    }
}
