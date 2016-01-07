public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        
        int index[] = new int[primes.length];
        for (int i=0;i<primes.length;i++) {
            index[i] = 0;
        }
        
        List<Long> data = new ArrayList<Long>();
        data.add((long)1);
        
        while(data.size()<n){
            long min = (long)primes[0]*data.get(index[0]);
            for (int i = 1;i<primes.length;i++) {
                long tmp = (long)primes[i]*data.get(index[i]);
                min = (tmp<min)?tmp:min;
            }
            data.add(min);
            for (int i=0;i<primes.length;i++) {
                if (min==(long)primes[i]*data.get(index[i]) ) index[i]++;
            }
        }
        return (int)((long)data.get(n-1));
    }
}