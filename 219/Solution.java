public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums==null ||nums.length == 0 || nums.length == 1 || k<1) {
            return false;
        }
        Set set = new HashSet();
        int head = 0;
        int tail = 0;
        for (;tail<=k;tail++) {
            if (tail>=nums.length) {
                return false;
            }
            if (set.contains(nums[tail])) {
                return true;
            } else {
                set.add(nums[tail]);
            }
        }
        tail--;
        
        while(tail<nums.length) {
            set.remove(nums[head]);
            head++;
            tail++;
            if (tail>=nums.length) {
                break;
            }
            if (set.contains(nums[tail])) {
                return true;
            } else {
                set.add(nums[tail]);
            }
        }
        return false;
        
        
    }
}