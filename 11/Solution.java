public class Solution {
    
    public int maxArea(int[] height) {
        if (height == null || height.length<=1) {
            return 0;
        }
        
        int l = height.length;
        int i = 0;
        int j = l-1;
        int max = 0;
        while(j>i) {
            int min = (height[i]>height[j])?height[j]:height[i];
            int cur = min*(j-i);
            if (cur>max) max=cur;
            if ( height[i]<height[j] ) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}