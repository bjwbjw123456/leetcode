public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || s.length()<t.length()){
            return "";
        }
        int[] need = new int[256];
        int[] count = new int[256];
        int rest = t.length();
        
        for (int i =0;i<t.length();i++) {
            char tmp = t.charAt(i);
            need[tmp]++;
        }
        
        int min = s.length()+1;
        int ss = 0;
        int ee = s.length()-1;
        
        int start = 0;
        int end = 0;
        int cur = 0;
        
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            if(rest>0) {
                if (need[tmp]>count[tmp]){
                    rest--;
                }
                if (need[tmp]>0) {
                    count[tmp]++;
                }
                end = i;
                if(rest==0) {
                    for(;start<=end;start++){
                        char tt = s.charAt(start);
                        if(count[tt]>need[tt]){
                            count[tt]--;
                        } else {
                            if (need[tt]>0) {
                                break;
                            }
                        }
                    }
                    if (end-start+1<min) {
                        min = end-start+1;
                        ss = start;
                        ee = end;
                    }    
                }
            } else {
                if(need[tmp]>0) {
                    end = i;
                    count[tmp]++;
                    for(;start<=end;start++){
                        char tt = s.charAt(start);
                        if(count[tt]>need[tt]){
                            count[tt]--;
                        } else {
                            if (need[tt]>0) {
                                break;
                            }
                        }
                    }
                }
                if (end-start+1<min) {
                    min = end-start+1;
                    ss = start;
                    ee = end;
                }
            }
        }
        
        return (rest>0)?"":s.substring(ss,ee+1);
    }
}