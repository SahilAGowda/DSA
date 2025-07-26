package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeTwoSortedArrayWithoutSpace {
    // Optimal  
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[index] = nums1[i];
                i--;
                index--;
            }else{
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        while(j>=0){
            nums1[index]=nums2[j];
            j--;
            index--;
        }
        
    }

    // Brute 
     public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]!=0){
                a.add(nums1[i]);
            }
        }

        for(int i=0;i<nums2.length;i++){
            a.add(nums2[i]);
        }
        Collections.sort(a);
        System.out.println(a);

        for(int i=0;i<nums1.length;i++){
              nums1[i] = a.get(i);
        }
     }

     public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        // merge1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
     }
}
