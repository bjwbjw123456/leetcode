public class Solution {
    private void helper(int[] nums, List<List<Integer>> r, List<Integer> cur) {
        if (nums.length == 0) r.add(cur);
        for (int i=0;i<nums.length;i++) {
            if (i>=1){
                if (nums[i]==nums[i-1]) continue;
            }
            List<Integer> newone = new ArrayList<Integer>(cur);
            newone.add(nums[i]);
            int[] newnums = new int[nums.length-1];
            for (int j=0;j<nums.length;j++) {
                if (j<i) newnums[j] = nums[j];
                else if (j>i) newnums[j-1] = nums[j];
                else continue;
            }
            helper(newnums,r,newone);
        }
        
    }
    
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (nums==null || nums.length ==0) {
            return r;
        } 
        int l = nums.length;
        List<Integer> cur = new ArrayList<Integer>();
        helper(nums,r,cur);
        return r;
    }
}