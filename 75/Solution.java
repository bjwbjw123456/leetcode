public class Solution {
    public void sortColors(int[] nums) {
        if (nums==null || nums.length<=1) return;
        int head = 0;
        int tail = nums.length-1;
        int i=0;
        
        while(i<nums.length){
            if (nums[i] == 0) {
                if (i<=head) {
                    i++;
                    head++;
                    continue;
                } else {
                    int tmp = nums[head];
                    nums[head] = 0;
                    nums[i] = tmp;
                    head++;
                }
            } else if (nums[i] == 2) {
                if (i>=tail){
                    tail--;
                    i++;
                    continue;
                } else {
                    int tmp = nums[tail];
                    nums[tail] = 2;
                    nums[i] = tmp;
                    tail--;
                }
            } else {
                i++;
            }
        }
        
    }
}