public class Solution {
    private int binarySearch(int[] dp, int x, int start, int end){
        if (start == end) return start;
        int middle = start+(end-start)/2;
        if((dp[middle]>x && dp[middle-1]<x)||dp[middle]==x) return middle;
        if (dp[middle]>x) return binarySearch(dp,x,start,middle-1);
        else return binarySearch(dp,x,middle+1,end);
    }
    
    
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length == 1) return 1;
        
        int[] dp = new int[nums.length+1];
        int curl = 1;
        dp[1] = nums[0];
        
        
        for(int i=1;i<nums.length;i++) {
            int start = 1;
            int end = curl;
            if (nums[i]>dp[curl]) {
                curl++;
                dp[curl] = nums[i];
                continue;
            } else if(nums[i]<dp[1]) {
                dp[1] = nums[i];
            } else {
                int index = binarySearch(dp,nums[i],1,curl);
                dp[index] = nums[i];
            }
        }
        
        return curl;
    }
}