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
    
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        int l = nums.length;
        int count;
        
        int n = l-1;
        for (int i=n;i>=1;i--){
            count = counting(nums,i);
            if (count<i+1) {
                return i+1;
            }
        }
        return 1;
    }
}