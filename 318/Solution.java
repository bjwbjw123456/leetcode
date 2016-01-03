public class Solution {
    public int maxProduct(String[] words) {
        if(words==null || words.length<=1) return 0;
        int[] data = new int[words.length];
        for (int i=0;i<words.length;i++) {
            String cur = words[i];
            for (int j=0;j<cur.length();j++) {
                data[i] = data[i] | (1<<(cur.charAt(j)-'a'));
            }
        }
        int max = 0;
        for (int i=0;i<words.length;i++) {
            for (int j=i+1;j<words.length;j++) {
                if ( (data[i] & data[j])==0){
                    int tmp = words[i].length()*words[j].length();
                    if (tmp>max) max = tmp;
                }
                
            }
        }
        return max;
    }
}