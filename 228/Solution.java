public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> r = new ArrayList<String>();
        if (nums==null || nums.length==0) return r;
        if (nums.length==1) {
            r.add(nums[0]+"");
            return r;
        }
        int curstart = nums[0];
        int curend = nums[0];
        for(int i=0;i<nums.length;i++) {
            if (nums[i] > curend+1) {
                if (curstart==curend) {
                    r.add(curstart+"");
                } else {
                    r.add(curstart+"->"+curend);
                }
                curstart = nums[i];
                curend = nums[i];
            } else {
                curend = nums[i];
            }
        }
        if (curstart==curend) {
            r.add(curstart+"");
        } else {
            r.add(curstart+"->"+curend);
        }
        return r;
    }
}