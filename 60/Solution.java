public class Solution {
    int[] data;
    
    private String helper(int k, int[] nums) {
        if (nums.length==1) return (""+nums[0]);
        int count = data[nums.length-2];
        String cur = ""+nums[(k-1)/count];
        int[] newnums = new int[nums.length-1];
        for (int i=0;i<nums.length;i++) {
            if (i<(k-1)/count) {
                newnums[i] = nums[i];
            } else if (i>(k-1)/count){
                newnums[i-1] = nums[i];
            } else {
                continue;
            }
        }
        int newk = (k%count==0)?count:k%count;
        return cur+helper(newk,newnums);
    }
    
    
    public String getPermutation(int n, int k) {
        int[] tmp = {1,2,6,24,120,720,5040,40320,362880};
        data = tmp;
        if (n==0) return "";
        if (k>data[n-1]) return "";
        if (n==1) return (""+n);
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = i+1;
        }
        return helper(k,nums);
    }
}