public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        s=s.replaceAll("( )+"," ");
        String[] data = s.split(" ");
        if (data.length==0) return "";
        if (data.length==1) return data[0];
        String r = new String(data[data.length-1]);
        for(int i=data.length-2;i>=0;i--) {
            if (data[i].equals("")) continue;
            r = r+ " " + data[i];
        }
        return r;
    }
}