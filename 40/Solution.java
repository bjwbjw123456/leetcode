public class Solution {
    List<List<Integer>> r;
    
    private void helper(int[] nums, int start, int count, int target, List<Integer> cur) {
        /*if (start==nums.length-1) {
            if (nums[start] == target-count) {
                List<Integer> tmp = new ArrayList<Integer>(cur);
                tmp.add(nums[start]);
                r.add(tmp);
            }
            return;
        }*/
        for (int i=start;i<nums.length;i++) {
            if (i!=start && nums[i]==nums[i-1]) continue;
            if (nums[i]>target-count) {
                return;
            }
            if (nums[i]==target-count) {
                List<Integer> tmp = new ArrayList<Integer>(cur);
                tmp.add(nums[i]);
                r.add(tmp);
                return;
            }
            List<Integer> tmp = new ArrayList<Integer>(cur);
            tmp.add(nums[i]);
            helper(nums,i+1,count+nums[i],target,tmp);
        }
        return;
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        r = new ArrayList<List<Integer>>();
        if (candidates==null || candidates.length==0) return r;
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        helper(candidates,0,0,target,cur);
        return r;
    }
}