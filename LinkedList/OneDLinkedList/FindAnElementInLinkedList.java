package LinkedList.OneDLinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class FindAnElementInLinkedList {
    public static boolean searchKey(Node head, int key) {
        // Code here
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(1);
        head.next.next = new Node(3);
        int key = 3;
        System.out.println(searchKey(head, key));
        
    }
}
