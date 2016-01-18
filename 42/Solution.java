public class Solution {
    public int trap(int[] height) {
        if (height==null || height.length<=2) return 0;
        int maxIndex = 0;
        int max = height[0];
        for (int i=1;i<height.length;i++) {
            if (height[i]>max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int r = 0;
        int maxNow = height[0];
        
        for (int i=0;i<maxIndex;i++) {
            int cur = height[i];
            if (cur>maxNow) {
                maxNow = cur;
                continue;
            } else {
                r += maxNow-cur;
            }
        }
        
        maxNow = height[height.length-1];
        for (int i=height.length-1;i>maxIndex;i--) {
            int cur = height[i];
            if (cur>maxNow) {
                maxNow = cur;
                continue;
            } else {
                r += maxNow-cur;
            }
        }
        return r;
    }
}