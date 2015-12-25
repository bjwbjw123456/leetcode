public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0||(nums.length == 1 && nums[0]<s) ){
            return 0;
        } 
        int tail = 0;
        int head = 0;
        int min = nums.length+1;
        int sum = 0;
        int curl = 0;
        for (; tail<nums.length; tail++) {
            sum+=nums[tail];
            curl++;
            if (sum>=s) {
                if (curl<min) {
                    min = curl;
                }
                for (;head<tail;head++) {
                    if (sum-nums[head] >=s) {
                        sum-=nums[head];
                        curl--;
                        if (curl<min) min = curl;
                    } else {
                        break;
                    }
                }
                
            }
            
        }
        return (min==nums.length+1)?0:min;
        
    }
}