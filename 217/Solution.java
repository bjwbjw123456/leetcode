public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        Set set = new HashSet();
        for (int i =0; i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
        
    }
}