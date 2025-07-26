package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {
    public static int[][] merge(int[][] intervals) {
        // int n = intervals.length;
        // //  Sorting the 2d Arrays in such a way that first if the 
        // // first element is not equal it would be compared based on the second
         
        // Arrays.sort(intervals,(a,b)->{
        //     if(a[0]!=b[0]){
        //         return Integer.compare(a[0],b[0]);
        //     }else{
        //         return Integer.compare(a[1],b[1]);
        //     }
        // });
        // System.out.println(Arrays.deepToString(intervals));
        // List<List<Integer>> a = new ArrayList<>();
        // // we would start loop extract the start and the end of the first one 
        // for(int i=0;i<n;i++){
        //     int start = intervals[i][0];
        //     int end = intervals[i][1];
        //     //  we would check if the ans is not empty and  end is already lieing in the interval
        //     if(!a.isEmpty() && end<=a.get(a.size()-1).get(1)){
        //         continue;
        //     }
        //     // loop to the other element to find the end for the start
        //     for(int j=i+1;j<n;j++){
        //         // check if the end element is less then the current start
        //         if(intervals[j][0]<=end){
        //             end = Math.max(end,intervals[j][1]);
        //         }else{
        //             break;
        //         }
        //     }
        //     ArrayList<Integer> temp = new ArrayList<>();
        //     temp.add(start);
        //     temp.add(end);
        //     a.add(temp);

        // }
        // int row = a.size();
        // int col = a.get(0).size();
        // int ans [][] = new int[row][col];
        // // System.out.println(Arrays.deepToString(ans));
        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         ans[i][j]=a.get(i).get(j); 
        //     }
        // }
        // // System.out.println(a);
        // return ans;








         int n = intervals.length;
        //  Sorting the 2d Arrays in such a way that first if the 
        // first element is not equal it would be compared based on the second
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(intervals,(a1,b1)->{
            if(a1[0]!=b1[0]){
                return Integer.compare(a1[0],b1[0]);
            }else{
                return Integer.compare(a1[1],b1[1]);
            }
        });
        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(a.isEmpty() || a.get(a.size() - 1).get(1) < start){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                a.add(temp);
            }else{
                List<Integer> last = a.get(a.size()-1); 
                last.set(1,Math.max(last.get(1),end));
            }
        }
         int row = a.size();
        int col = a.get(0).size();
        int ans [][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans[i][j]=a.get(i).get(j); 
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[][]={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(nums)));
    }
}
