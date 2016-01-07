public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height==null || height.length==0) return 0;
        
        int[] data = new int[height.length+1];
        for (int j=0;j<height.length;j++) {
            data[j] = height[j];
        }
        data[height.length] = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i=0;
        while(i<data.length) {
            if (stack.empty() || data[i]>=data[stack.peek()]) {
                stack.push(i);
                i++;
                continue;
            }
            int index = stack.peek();
            stack.pop();
            int ll = (stack.empty())?i:i-stack.peek()-1;
            int cur = ll*data[index];
            max = (cur>max)?cur:max;
        }
        return max;
    }
}