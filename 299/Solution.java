public class Solution {
    public String getHint(String secret, String guess) {
        if(secret.length()==0) return "0A0B";
        int l = secret.length();
        int bull = 0;
        int cow = 0;
        HashMap<String , Integer> map = new HashMap<String , Integer>();   
        for (int i=0;i<l;i++) {
            if(secret.charAt(i)==guess.charAt(i)) {
                bull++;
            } else {
                int k = 0;
                if ( map.containsKey(secret.substring(i,i+1)) ){
                    k = map.get( secret.substring(i,i+1) );
                } 
                k++;
                map.put(secret.substring(i,i+1),k);
            }
        }
        for (int i=0;i<l;i++) {
            if(secret.charAt(i)==guess.charAt(i)) {
                continue;
            } else {
                int k = 0;
                if ( map.containsKey(guess.substring(i,i+1)) ){
                    k = map.get( guess.substring(i,i+1) );
                    cow++;
                    k--;
                }
                if (k == 0) {
                    map.remove( guess.substring(i,i+1) );
                } else {
                    map.put(guess.substring(i,i+1),k);
                }
                    
                
            }
        }
        return bull+"A"+cow+"B";
        
        
        
    }
}