public class Solution {
    int max;
    
    private void helper(int[] height) {
        if (height==null || height.length==0) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        while(i<height.length) {
            if(stack.empty() || height[i]>=height[stack.peek()]){
                stack.push(i);
                i++;
                continue;
            } 
            
            int index = stack.peek();
            stack.pop();
            int ll = (stack.empty())?i:i-stack.peek()-1;
            int tmp = height[index]*ll;
            max = (tmp>max)?tmp:max;
        }
        //System.out.println(max);
    }
    
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length == 0) return 0;
        max = 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] data = new int[m][n+1];
        for(int j=0;j<n+1;j++) {
            for(int i=0;i<m;i++) {
                data[i][j] = 0;
            }
        }
        
        for(int j=0;j<n;j++) {
            data[0][j] = (matrix[0][j]=='1')?1:0;
        }
        
        for(int j=0;j<n;j++) {
            for(int i=1;i<m;i++) {
                data[i][j] = (matrix[i][j]=='1')?data[i-1][j]+1:0;
            }
        }
        
        /*for(int i=0;i<m;i++) {
            for (int j=0;j<n+1;j++) {
                System.out.print(""+data[i][j] + ",");
            }
            System.out.print("\n");
        }*/
        
        for(int i=0;i<m;i++) {
            helper(data[i]);
        }
        return max;
        
    }
}