public class Solution {
    int minIndex;
    
    private int helper(int[] nums, int start, int end) {
        if (nums[start] < nums[end]) return start;
        if (start==end) return start;
        int middle = start + (end-start)/2;
        if( (middle==0 && nums[middle]<nums[middle+1]) || (middle!=0 && nums[middle]<nums[middle-1]) ) return middle;
        if (nums[middle] >= nums[start]) return helper(nums,middle+1,end);
        else return helper(nums,start,middle-1);
    }
    
    public int findMin(int[] nums) {
        if (nums.length==1) return 0;
        return helper(nums,0,nums.length-1);
    }
    
    private int find(int[] nums, int target, int start, int end){
        if (nums[start]<nums[end]) return binarySearch(nums,target,start,end);
        if (start>end) return -1;
        if (start==end) {
            if (nums[start] == target) return start;
            else return -1;
        }
        int middle = start+(end-start)/2;
        if (nums[middle]==target) return middle;
        if (nums[middle]>target) {
            if (minIndex<=middle){
                return binarySearch(nums, target, minIndex, middle-1);
            } else {
                int tmp = binarySearch(nums, target, start, middle-1);
                if (tmp!=-1) return tmp;
                else return binarySearch(nums,target, minIndex, end);
            }
        } else {
            if (middle<minIndex){
                return binarySearch(nums, target, middle+1, minIndex-1);
            } else {
                int tmp = binarySearch(nums,target, middle+1, end);
                if (tmp!=-1) return tmp;
                else return binarySearch(nums,target,start,minIndex-1);
            }
            
        }
        
    }
    
    private int binarySearch(int[] nums, int target,int start, int end) {
        if (start>end) return -1;
        if (start==end) return (nums[start]==target)?start:-1;
        int middle = start + (end-start)/2;
        if (nums[middle]==target) return middle;
        if (nums[middle] > target) return binarySearch(nums,target,start, middle-1);
        else return binarySearch(nums,target,middle+1, end);
    }
    
    public int search(int[] nums, int target) {
        minIndex = findMin(nums);
        //System.out.println(minIndex);
        return find(nums,target,0,nums.length-1);
    }
}