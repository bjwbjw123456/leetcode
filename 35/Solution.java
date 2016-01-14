public class Solution {
    private int helper(int[] nums, int target, int start, int end) {
        if (start==end) {
            if (nums[start] >= target ) return start;
            else return start+1;
        }
        int middle = start+(end-start)/2;
        if ( (middle==0 && nums[middle] >= target) || (middle!=0&&nums[middle]>=target&&nums[middle-1]<target) ) return middle;
        else if (nums[middle]>target) return helper(nums,target,start,middle-1);
        else return helper(nums,target,middle+1,end);
    }
    
    public int searchInsert(int[] nums, int target) {
        if (nums==null || nums.length==0) return 0;
        return helper(nums,target,0,nums.length-1);
    }
}