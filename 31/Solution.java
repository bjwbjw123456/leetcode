public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length <=1) return;
        int l = nums.length;
        int i =0;
        for (i = l-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) break;
        }
        int index = i;
        
        if (i>=0) {
            int base = nums[i];
            for (int j = l-1;j>index;j--) {
                if (nums[j] > base) {
                    int tmp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        } 
        
        i = index+1;
        int j = l-1;
        while(j>i){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}