package LinkedList.ProblemsOnDLL;

public class RemoveDuplicatesFromSortedDLL {
    /*
     * Given a doubly linked list of n nodes sorted by values, the task is to remove
     * duplicate nodes present in the linked list.
     * 
     * Example 1:
     * 
     * Input:
     * n = 6
     * 1<->1<->1<->2<->3<->4
     * Output:
     * 1<->2<->3<->4
     * Explanation:
     * Only the first occurance of node with value 1 is
     * retained, rest nodes with value = 1 are deleted.
     * Example 2:
     * 
     * Input:
     * n = 7
     * 1<->2<->2<->3<->3<->4<->4
     * Output:
     * 1<->2<->3<->4
     * Explanation:
     * Only the first occurance of nodes with values 2,3 and 4 are
     * retained, rest repeating nodes are deleted.
     * Your Task:
     * You have to complete the method removeDuplicates() which takes 1 argument:
     * the head of the linked list. Your function should return a pointer to a
     * linked list with no duplicate element.
     * 
     * Constraint:
     * 1 <= n <= 105
     * Expected Time Complexity: O(n)
     * Expected Space Complexity: O(1)
     * 
     * 
     */
    static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null)
                nextNode.prev = temp;
            temp = nextNode;

        }
        return head;
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(1);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Original List:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
