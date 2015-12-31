public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        if (l == 0) {
            return 0;
        }
        if (l==1) {
            return triangle.get(0).get(0);
        }
        int[] old = new int[l];
        int[] dp = new int[l];
        old[0] = triangle.get(0).get(0);
        for(int i=1;i<l;i++) {
            dp[0] = triangle.get(i).get(0)+old[0];
            for(int j=1;j<i;j++) {
                dp[j] = Math.min(old[j-1],old[j])+triangle.get(i).get(j);
            }
            dp[i] = triangle.get(i).get(i)+old[i-1];
            int[] tmp = old;
            old = dp;
            dp = tmp;
        }
        int r = old[0];
        for(int i=1;i<l;i++) {
            r = (old[i]<r)?old[i]:r;
        }
        return r;
    }
}