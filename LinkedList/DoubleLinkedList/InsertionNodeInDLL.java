package LinkedList.DoubleLinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

public class InsertionNodeInDLL {
    public static Node insertHead(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static Node insertTail(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node newNode = new Node(data);
        newNode.prev = prev;
        newNode.next = tail;
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }

    public static Node insertKthPos(Node head, int pos, int k) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == pos) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.prev;
        if (prev == null) {
            return insertHead(head, k);
        } else if (temp.next == null) {
            return insertTail(head, k);
        }
        Node newNode = new Node(k);
        newNode.next = temp;
        newNode.prev = prev;
        prev.next = null;
        temp.prev = null;
        return head;

    }
    public static Node insertBeforeElement(Node head, int data, int element) {
        if (head == null) {
            return null;
        }
        if (head.data == element) {
            Node temp = new Node(data);
            temp.next = head;
            head.prev = temp;
            return temp;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == element) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
                return head;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        int pos = 2;
        int k = 5;
        head = insertKthPos(head, pos, k);
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
     
           }
       }
}
