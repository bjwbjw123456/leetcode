public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null) return 0;
        if (nums.length<=1) return nums.length;
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        int max = 0;
        
        for (int i=0;i<nums.length;i++) {
            int l = 0;
            int cur = nums[i]-1;
            while(set.contains(cur)) {
                l++;
                set.remove(cur);
                cur--;
            }
            
            int r = 0;
            cur = nums[i];
            while(set.contains(cur)) {
                r++;
                set.remove(cur);
                cur++;
            }
            max = (l+r>max)?l+r:max;
        }
        return max;
    }
}