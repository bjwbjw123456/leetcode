public class Solution {
    public int singleNumber(int[] nums) {
        int[] data = new int[32];
        for (int i=0; i<nums.length;i++) {
            for (int j=0;j<32;j++) {
                data[j] += (nums[i]>>j)&1;
            }
        }
        int r = 0;
        for (int i=0;i<32;i++){
            r = r|((data[i]%3)<<i);
        }
        return r;
        
    }
}