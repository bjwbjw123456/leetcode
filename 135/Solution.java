public class Solution {
    public int candy(int[] ratings) {
        if (ratings==null || ratings.length==0) return 0;
        if (ratings.length==1) return 1;
        int l =ratings.length;
        
        int[] number = new int[l];
        
        for(int i=0;i<l;i++) {
            number[i] = 1;
        }
        
        for(int i=1;i<l;i++) {
            if (ratings[i]>ratings[i-1]) {
                number[i] = number[i-1]+1;
            }
        }
        
        for(int i=l-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1] && number[i]<=number[i+1]){
                number[i] = number[i+1]+1;
            }
        }
        
        int count = 0;
        
        for(int i=0;i<l;i++) {
            count+=number[i];
        }
        return count;
    }
}