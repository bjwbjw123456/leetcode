public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x<10) return true;
        int base = 10;
        while(x/base>=10) {
            base*=10;
        }
        
        while(x>0) {
            int a = x%10;
            int b = x/base;
            if (a!=b) return false;
            x = x-a;
            x = x-base*b;
            x =x/10;
            base/=100;
        }
        return true;
        
        
    }
}