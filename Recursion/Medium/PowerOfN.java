package Recursion.Medium;

public class PowerOfN {
    /*
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     * 
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     * 
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     */
    public static double myPow(double x, int n) {
        double ans =1.0;
        long temp = n;
        if(temp<0) temp =temp*-1;
        while(temp>0){
            if(temp%2==1){
                ans = ans * x;
                temp = temp-1;
            }else{
                x = x*x;
                temp=temp/2;
            }
        }
        if(n<0) return 1/ans;
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10)); // 1024.00000
        System.out.println(myPow(2.10000, 3));  // 9.26100
        System.out.println(myPow(2.00000, -2)); // 0.25000
    }
}
