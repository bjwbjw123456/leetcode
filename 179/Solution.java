public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        if (nums.length==1) return ""+nums[0];
        String[] data = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            data[i] = ""+nums[i];
        } 
        Arrays.sort(data,new Comparator(){
           public int compare(Object obj1,Object obj2){
               String a = (String)obj1;
               String b = (String)obj2;
               if (a.equals(b)) return 0;
               
               while(a.length()!=b.length()){
                   int l1 = a.length();
                   int l2 = b.length();
                   if (l1>l2) {
                       String tmp = a.substring(0,l2);
                       if (tmp.equals(b)) {
                           a = a.substring(l2);
                       } else {
                           break;
                       }
                   } else {
                       String tmp = b.substring(0,l1);
                       if (tmp.equals(a)) {
                           b = b.substring(l1);
                       } else {
                           break;
                       }
                   }
               }
               
               if (a.equals(b)) return 0;
               
               int l1 = a.length();
               int l2 = b.length();
               int l = (l1<l2)?l1:l2;
               
               for (int i=0;i<l;i++) {
                   char aa = a.charAt(i);
                   char bb = b.charAt(i);
                   if (aa>bb) return -1;
                   else if (aa<bb) return 1;
                   else {
                       continue;
                   }
               } 
               
               return 0;
           } 
        });
        
        String r = "";
        for (int i=0;i<data.length;i++){
            r = r+data[i];
        }
        if (r.charAt(0)=='0') r = "0";
        return r;
    }
}