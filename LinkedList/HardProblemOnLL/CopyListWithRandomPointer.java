package LinkedList.HardProblemOnLL;

class RandomPointingNode {
    int val;
    RandomPointingNode next;
    RandomPointingNode random;

    RandomPointingNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    /*
     * A linked list of length n is given such that each node contains an additional
     * random pointer, which could point to any node in the list, or null.
     * 
     * Construct a deep copy of the list. The deep copy should consist of exactly n
     * brand new nodes, where each new node has its value set to the value of its
     * corresponding original node. Both the next and random pointer of the new
     * nodes should point to new nodes in the copied list such that the pointers in
     * the original list and copied list represent the same list state. None of the
     * pointers in the new list should point to nodes in the original list.
     * 
     * For example, if there are two nodes X and Y in the original list, where
     * X.random --> Y, then for the corresponding two nodes x and y in the copied
     * list, x.random --> y.
     * 
     * Return the head of the copied linked list.
     * 
     * The linked list is represented in the input/output as a list of n nodes. Each
     * node is represented as a pair of [val, random_index] where:
     * 
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1) that the random
     * pointer points to, or null if it does not point to any node.
     * Your code will only be given the head of the original linked list.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * Example 2:
     * 
     * 
     * Input: head = [[1,1],[2,1]]
     * Output: [[1,1],[2,1]]
     * Example 3:
     * 
     * 
     * 
     * Input: head = [[3,null],[3,0],[3,null]]
     * Output: [[3,null],[3,0],[3,null]]
     * 
     * 
     * Constraints:
     * 
     * 0 <= n <= 1000
     * -104 <= Node.val <= 104
     * Node.random is null or is pointing to some node in the linked list.
     */
    public static void insertNode(RandomPointingNode head) {
        RandomPointingNode temp = head;
        while (temp != null) {
            RandomPointingNode newNode = new RandomPointingNode(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    public static void printLL(RandomPointingNode head) {
        RandomPointingNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void insertRandomPointer(RandomPointingNode head) {
        RandomPointingNode temp = head;
        while (temp != null) {
            RandomPointingNode copyNode = temp.next;
            if (temp.random == null) {
                copyNode.random = null;
            } else
                copyNode.random = temp.random.next;
            temp = temp.next.next;
        }
    }

    public static RandomPointingNode removeOriginalList(RandomPointingNode head) {
        RandomPointingNode dummy = new RandomPointingNode(-1);
        RandomPointingNode res = dummy;
        RandomPointingNode temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static RandomPointingNode copyRandomList(RandomPointingNode head) {
        insertNode(head);
        insertRandomPointer(head);

        printLL(head);
        return removeOriginalList(head);
    }
    public static void main(String[] args) {
        RandomPointingNode head = new RandomPointingNode(7);
        head.next = new RandomPointingNode(13);
        head.next.next = new RandomPointingNode(11);
        head.next.next.next = new RandomPointingNode(10);
        head.next.next.next.next = new RandomPointingNode(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        RandomPointingNode newHead = copyRandomList(head);
        printLL(newHead);
    }
}
