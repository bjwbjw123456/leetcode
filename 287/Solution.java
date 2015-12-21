public class Solution {
    private int counting(int[] nums, int max) {
        int l = nums.length;
        int count = 0;
        for (int i=0; i<l; i++) {
            if (nums[i]<=max) {
                count++;
            } 
        }
        return count;
    }
    
    private int helper(int[] nums, int l, int r) {
        int k = (l+r)/2;
        int count = counting(nums,k);
        if (count>=k+1) {
            return helper(nums,l,k);
        } else {
            int count1 = counting(nums,k+1);
            if (count1>=k+2) {
                return k+1;
            } else {
                return helper(nums,k,r);
            }
        }
    }
    
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        int l = nums.length;
        int count;
        
        int n = l-1;
        return helper(nums,0,n);
    }
}