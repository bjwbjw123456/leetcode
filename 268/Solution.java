public class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int n = l;
        int base = (0+n)*(n+1)/2;
        int sum = 0;
        for(int i=0;i<l;i++) {
            sum+=nums[i];
        }
        return (base-sum);
    }
}