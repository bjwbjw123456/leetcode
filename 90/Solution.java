public class Solution {
    List<List<Integer>> r;
    int length;
    
    private void helper(int[] nums,int start, List<Integer> cur){
        if (start==length) {
            r.add(cur);
            return;
        }
        for(int i=start;i<length;i++) {
            if (i!=start && nums[i]==nums[i-1]) continue;
            List<Integer> tmp = new ArrayList<Integer>(cur);
            //List<Integer> tmp1 = new ArrayList<Integer>(cur);
            tmp.add(nums[i]);
            helper(nums,i+1,tmp);
            //helper(nums,i+1,cur);
        }
        r.add(cur);
        return;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        r = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        length = nums.length;
        List<Integer> cur = new ArrayList<Integer>();
        helper(nums,0,cur);
        return r;
    }
}