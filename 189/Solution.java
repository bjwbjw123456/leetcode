public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int l = nums.length;
        int step = l-k%l;
        if (step == 0) {
            return;
        }
        int[] r = new int[l];
        for (int i=0;i<l;i++) {
            int tmp = step + i;
            r[i] = nums[tmp%l];
        }
        for (int i=0;i<l;i++) {
            nums[i] = r[i];
        }
        
        
    }
}