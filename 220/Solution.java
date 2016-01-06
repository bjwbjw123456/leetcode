public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums==null || nums.length<=1 || k<=0 || t<0) return false;
        
        SortedSet<Long> set = new TreeSet<Long>();
        
        for(int i=0;i<nums.length;i++) {
            SortedSet<Long> subset = set.subSet(new Long(nums[i])-t,new Long(nums[i])+t+1);
            if (!subset.isEmpty()) return true;
            if (i>=k) {
                set.remove(new Long(nums[i-k]));
            }
            set.add(new Long(nums[i]));
        }
        return false;
    }
}