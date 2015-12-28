public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int top = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) continue;
            nums[top] = nums[i];
            top++;
        }
        for (int i=top;i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}