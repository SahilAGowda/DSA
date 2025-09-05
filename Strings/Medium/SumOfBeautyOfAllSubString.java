package Medium;

public class SumOfBeautyOfAllSubString {
    /*
     * The beauty of a string is the difference in frequencies between the most
     * frequent and least frequent characters.
     * 
     * For example, the beauty of "abaacc" is 3 - 1 = 2.
     * Given a string s, return the sum of beauty of all of its substrings.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "aabcb"
     * Output: 5
     * Explanation: The substrings with non-zero beauty are
     * ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
     * Example 2:
     * 
     * Input: s = "aabcbaa"
     * Output: 17
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 500
     * s consists of only lowercase English letters.
     */

    // !! Brute Approach

//  !! static int calculateBeauty(String str){
    // !!HashMap<Character,Integer> hm = new HashMap<>();
    // !!for(int i=0;i<str.length();i++){
    // !!hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
    // !!}
    // !!int min = Integer.MAX_VALUE;
    // !!int max = Integer.MIN_VALUE;
    // !!for(Map.Entry<Character,Integer>e:hm.entrySet()){
    // !!min = Math.min(min,e.getValue());
    // !!max = Math.max(max,e.getValue());
    // !!}
    // !!return max-min;
    // !!}
    // !!public int beautySum(String s) {
    // !!int ans=0;
    // !!for(int i=0;i<s.length();i++){
    // !!for(int j=i;j<s.length();j++){
    // !!int val = calculateBeauty(s.substring(i,j+1));
    // !!if(val==0)continue;
    //!! ans+=(val);

    //!! }
    // !!}
    //!! return ans;
    //!! }

    public static int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }
                ans += (max - min);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

}
