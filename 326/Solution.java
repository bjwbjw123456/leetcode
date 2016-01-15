public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        int maxPow = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
        int max = (int)Math.pow(3,maxPow);
        return (max%n==0);
        
    }
}