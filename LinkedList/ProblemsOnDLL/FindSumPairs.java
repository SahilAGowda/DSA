package LinkedList.ProblemsOnDLL;

import java.util.ArrayList;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class FindSumPairs {
    /*
     * Given a sorted doubly linked list of positive distinct elements, the task is
     * to find pairs in a doubly-linked list whose sum is equal to given value
     * target.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input:
     * 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
     * target = 7
     * Output: (1, 6), (2,5)
     * Explanation: We can see that there are two pairs
     * (1, 6) and (2,5) with sum 7.
     * 
     * 
     * Example 2:
     * 
     * Input:
     * 1 <-> 5 <-> 6
     * target = 6
     * Output: (1,5)
     * Explanation: We can see that there is one pairs (1, 5) with sum 6.
     * 
     * 
     * 
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete the
     * function findPairsWithGivenSum() which takes head node of the doubly linked
     * list and an integer target as input parameter and returns an array of pairs.
     * If there is no such pair return empty array.
     * 
     * Expected Time Complexity: O(N)
     * Expected Auxiliary Space: O(1)
     * Constraints:
     * 1 <= N <= 105
     * 1 <= target <= 105
     */
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum1(int target,
            Node head) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node temp1 = head;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null) {
                if (temp2.data + temp1.data == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(temp1.data);
                    temp.add(temp2.data);
                    res.add(temp);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;

        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
            Node head) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (right.data > left.data) {
            if (left.data + right.data == target) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(left.data);
                a.add(right.data);
                res.add(a);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data > target) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(9);   

        head.next.next.next.next.next.next.prev = head.next.next.next.next;
        int target = 7;
        ArrayList<ArrayList<Integer>> res = findPairsWithGivenSum(target, head); 
        System.out.println("Pairs with given sum " + target + " :");   
        for (ArrayList<Integer> pair : res) {
            System.out.println(pair);
        }

        ArrayList<ArrayList<Integer>> res1 = findPairsWithGivenSum1(target, head);
        System.out.println("Pairs with given sum " + target + " :");
        for (ArrayList<Integer> pair : res1) {
            System.out.println(pair);
        }

    }
}