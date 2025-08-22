package BinarySearch.BinarySearchOnAnswers;

class Kthelementof2sortedarrays {
    /*
     * Given two sorted arrays a[] and b[] and an element k, the task is to find the
     * element that would be at the kth position of the combined sorted array.
     * 
     * Examples :
     * 
     * Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
     * Output: 6
     * Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8,
     * 9, 10]. The 5th element of this array is 6.
     * Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
     * Output: 10
     * Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17].
     * The 6th element of this array is 10.
     * Constraints:
     * 1 ≤ a.size(), b.size() ≤ 106
     * 1 ≤ k ≤ a.size() + b.size()
     * 0 ≤ a[i], b[i] ≤ 108
     */

    public static int kthElement(int a[], int b[], int k) {
        // code here
        int count = 1;
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;
        int elem = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (count == k) {
                    elem = a[i];
                    break;
                }
                count++;
                i++;
            } else {
                if (count == k) {
                    elem = b[j];
                    break;
                }
                count++;
                j++;
            }
        }
        while (i < n1) {
            if (count == k && elem == 0) {
                elem = a[i];
                break;
            }
            i++;
            count++;
        }
        while (j < n2) {
            if (count == k && elem == 0) {
                elem = b[j];
                break;
            }
            j++;
            count++;
        }
        return elem;
    }
    public static void main(String[] args) {
        int a[]={2, 3, 6, 7, 9};
        int b[]={1,4,8,10};
        int k=5;
        System.out.println(kthElement(a,b,k));
    }
}
