package LinkedList.ProblemsOnDLL;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class DeleteAllOccurances {
    /*
     * You are given the head_ref of a doubly Linked List and a Key. Your task is to
     * delete all occurrences of the given key if it is present and return the new
     * DLL.
     * 
     * Example1:
     * 
     * Input:
     * 2<->2<->10<->8<->4<->2<->5<->2
     * 2
     * Output:
     * 10<->8<->4<->5
     * Explanation:
     * All Occurences of 2 have been deleted.
     * 
     * Example2:
     * 
     * Input:
     * 9<->1<->3<->4<->5<->1<->8<->4
     * 9
     * Output:
     * 1<->3<->4<->5<->1<->8<->4
     * Explanation:
     * All Occurences of 9 have been deleted.
     * Your Task:
     * 
     * Complete the function void deleteAllOccurOfX(struct Node** head_ref, int
     * key), which takes the reference of the head pointer and an integer value key.
     * Delete all occurrences of the key from the given DLL.
     * 
     * Expected Time Complexity: O(N).
     * 
     * Expected Auxiliary Space: O(1).
     * 
     * Constraints:
     * 
     * 1<=Number of Nodes<=105
     * 
     * 0<=Node Value <=109
     */
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(10);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(8);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;

        int x = 2;
        head = deleteAllOccurOfX(head, x);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp .next;
        }
    }
}
