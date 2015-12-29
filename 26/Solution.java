public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        } 
        if (nums.length == 1) return 1;
        
        int top = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]!=nums[i-1]) {
                nums[top] = nums[i];
                top++;
                continue;
            }
        }
        return top;
    }
}