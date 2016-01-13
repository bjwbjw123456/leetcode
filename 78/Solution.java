public class Solution {
    private List<List<Integer>> helper(int[] nums, int start, int end) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (start > end) {
            List<Integer> tmp = new ArrayList<Integer>();
            r.add(tmp);
            return r;
        }
        if (start == end) {
            List<Integer> tmp = new ArrayList<Integer>();
            r.add(tmp);
            tmp = new ArrayList<Integer>();
            tmp.add(nums[start]);
            r.add(tmp);
            return r;
        }
            
        r = helper(nums,start,end-1);
        int l = r.size();
        for(int i=0;i<l;i++){
            List<Integer> tmp = new ArrayList<Integer>(r.get(i));
            tmp.add(nums[end]);
            r.add(tmp);
        }
        return r;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (nums==null) return r;
        if (nums.length==0) {
            List<Integer> tmp = new ArrayList<Integer>();
            r.add(tmp);
            return r;
        }
        Arrays.sort(nums);
        
        return helper(nums,0,nums.length-1);
    }
}