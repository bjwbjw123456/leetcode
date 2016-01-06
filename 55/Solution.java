public class Solution {
    public boolean canJump(int[] nums) {
        if (nums==null || nums.length<=1) return true;
        int max = 0;
        for(int i=0;i<nums.length-1;i++) {
            if (max>=nums.length-1) return true;
            if (i<=max) {
                int tmp = i+nums[i];
                max = (tmp>max)?tmp:max;
            }
        }
        return (max>=nums.length-1);
        
    }
}