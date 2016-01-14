public class Solution {
    private int helper(int[] nums, int start, int end) {
        if (nums[start] < nums[end]) return nums[start];
        if (start==end) return nums[start];
        int middle = start + (end-start)/2;
        if( (middle==0 && nums[middle]<nums[middle+1]) || (middle!=0 && nums[middle]<nums[middle-1]) ) return nums[middle];
        if (nums[middle] >= nums[start]) return helper(nums,middle+1,end);
        else return helper(nums,start,middle-1);
    }
    
    public int findMin(int[] nums) {
        if (nums.length==1) return nums[0];
        return helper(nums,0,nums.length-1);
    }
}