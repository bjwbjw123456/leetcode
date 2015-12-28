public class Solution {
    public int countPrimes(int n) {
        if (n <=2 ) return 0;
        boolean[] data = new boolean[n];
        for (int i =0;i<n;i++) {
            data[i] = true;
        }
        for (int i =2; i*i<=n ;i++) {
            if (!data[i]) continue;
            for (int j = i*i;j<n;j=j+i) {
                data[j] = false;
            }
        }
        int count = 0;
        for (int i = 2;i<n;i++) {
            if (data[i]) count++;
        }
        return count;
        
        
    }
}