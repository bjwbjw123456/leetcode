public class Solution {
    private int max(int a,int b){
        return (a>b)?a:b;
    }
    private int min(int a, int b) {
        return (a<b)?a:b;
    }
    
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int[] maxdata = new int[nums.length];
        int[] mindata = new int[nums.length];
        maxdata[0] = nums[0];
        mindata[0] = nums[0];
        for (int i = 1;i<nums.length;i++) {
            maxdata[i] = max( max(nums[i],maxdata[i-1]*nums[i]),mindata[i-1]*nums[i] );
            mindata[i] = min( min(nums[i],maxdata[i-1]*nums[i]),mindata[i-1]*nums[i] );
            if (maxdata[i] > max) {
                max = maxdata[i];
            }
        }
        return max;
    }
}