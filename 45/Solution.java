public class Solution {
    public int jump(int[] nums) {
        if (nums==null || nums.length<=1) return 0;
        int pre = 0;
        int cur = nums[0];
        int count = 0;
        
        for(int i=1;i<nums.length;i++) {
            if (cur>=nums.length-1) {
                count++;
                break;
            }
            if (i>pre) {
                count++;
                pre = cur;
                cur = i+nums[i];
                continue;
            }
            cur = (nums[i]+i>cur)?nums[i]+i:cur;
        }
        return count;
    }
}