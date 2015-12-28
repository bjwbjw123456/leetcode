public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int curl = nums.length;
        int tail = nums.length-1;
        for (int i=0;i<curl;i++) {
            if (nums[i]!=val) continue;
            nums[i] = nums[tail];
            tail--;
            curl--;
            if (curl == 0) {
                return 0;
            }
            i--;
        }
        return curl;
    }
}