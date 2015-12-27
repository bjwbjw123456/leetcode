public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int[] data = new int[nums.length];
        data[0] = nums[0];
        for (int i =1;i<nums.length;i++) {
            data[i] = (data[i-1]>0)?data[i-1]+nums[i]:nums[i];
            if (data[i]>max) max = data[i];
        }
        return max;
        
    }
}