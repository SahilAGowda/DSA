package LinkedList.OneDLinkedList;

class LenNode {
    int data;
    LenNode next;

    LenNode(int data) {
        this.data = data;
    }
}

public class LengthOfLinkedList {

    public static int calculateLen(LenNode head) {
        if (head == null) {
            return 0;
        }
        LenNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LenNode head = new LenNode(4);
        head.next = new LenNode(1);
        head.next.next = new LenNode(3);
        System.out.println(calculateLen(head));
    }

}
