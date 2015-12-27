public class Solution {
    public int numDistinct(String s, String t) {
        if (t == null || t.length() == 0) {
            return 1;
        }
        if (s == null || s.length() < t.length()) {
            return 0;
        }
        int l1 = s.length();
        int l2 = t.length();
        int[][] data = new int[l1+1][l2+1];
        for (int i =0;i<l1+1;i++) {
            data[i][0] = 1;
        }
        for(int i=1;i<l2+1;i++) {
            data[0][i] = 0;
        }
        for (int i = 1;i<l1+1;i++) {
            for (int j = 1;j<l2+1;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    data[i][j] = data[i-1][j-1] + data[i-1][j];
                } else {
                    data[i][j] = data[i-1][j];
                }
            }
        }
        return data[l1][l2];
    }
}

//http://www.cnblogs.com/ganganloveu/p/3836519.html