package LinkedList.HardProblemOnLL;

import java.util.ArrayList;
import java.util.Collections;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenALinkedList {
    /*
     * Given a linked list containing n head nodes where every node in the linked
     * list contains two pointers:
     * (i) next points to the next node in the list.
     * (ii) bottom points to a sub-linked list where the current node is the head.
     * Each of the sub-linked lists nodes and the head nodes are sorted in ascending
     * order based on their data. Flatten the linked list such that all the nodes
     * appear in a single level while maintaining the sorted order.
     * 
     * Note:
     * 1. ↓ represents the bottom pointer and → represents the next pointer.
     * 2. The flattened list will be printed using the bottom pointer instead of the
     * next pointer.
     * 
     * Examples:
     * 
     * Input:
     * 
     * Output: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
     * Explanation:
     * Bottom pointer of 5 is pointing to 7.
     * Bottom pointer of 7 is pointing to 8.
     * Bottom pointer of 10 is pointing to 20 and so on.
     * So, after flattening the linked list the sorted list will be
     * 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
     * Input:
     * 
     * Output: 5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50
     * Explanation:
     * Bottom pointer of 5 is pointing to 7.
     * Bottom pointer of 7 is pointing to 8.
     * Bottom pointer of 8 is pointing to 30 and so on.
     * So, after flattening the linked list the sorted list will be
     * 5 -> 7 -> 8 -> 10 -> 19 -> 22 -> 28 -> 30 -> 50.
     * Constraints:
     * 0 ≤ n ≤ 100
     * 1 ≤ number of nodes in sub-linked list(mi) ≤ 50
     * 1 ≤ node->data ≤ 104
     */

    public static Node convertLL(ArrayList<Integer> a) {
        if (a.size() == 0)
            return null;
        Node head = new Node(a.get(0));
        Node temp = head;
        for (int i = 1; i < a.size(); i++) {
            Node newNode = new Node(a.get(i));
            temp.bottom = newNode;
            temp = newNode;
        }
        return head;
    }

    public static Node flatten(Node root) {
        // code here
        Node temp = root;
        ArrayList<Integer> a = new ArrayList<>();
        while (temp != null) {
            Node childPtr = temp;
            while (childPtr != null) {
                a.add(childPtr.data);
                childPtr = childPtr.bottom;
            }
            temp = temp.next;
        }
        Collections.sort(a);
        return convertLL(a);
    }

    public static Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.bottom = l1;
                temp = l1;
                l1 = l1.bottom;
            } else {
                temp.bottom = l2;
                temp = l2;
                l2 = l2.bottom;
            }

        }
        if (l1 != null) {
            temp.bottom = l1;
        }
        if (l2 != null) {
            temp.bottom = l2;
        }
        return dummy.bottom;
    }

    public static Node flattenOptimal(Node root) {
        // the optimal logic we would be using recursion
        if (root == null || root.next == null) {
            return root;
        }
        Node mergeHead = flatten(root.next);
        return merge(root, mergeHead);
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        Node flatHead = flattenOptimal(head);
        while (flatHead != null) {
            System.out.print(flatHead.data + " ");
            flatHead = flatHead.bottom;
        }
    }
}
