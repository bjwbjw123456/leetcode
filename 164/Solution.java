public class Solution {
    public class bucket{
        int max;
        int min;
        public bucket(){
            max = -1;
            min = -1;
        }
    }
    
    public int maximumGap(int[] nums) {
        if (nums==null || nums.length<2) return 0;
        int max = nums[0];
        int min = nums[0];
        int l = nums.length;
        for (int i=0;i<l;i++) {
            max = (nums[i]>max)?nums[i]:max;
            min = (nums[i]<min)?nums[i]:min;
        }
        
        int avegap = (int)Math.ceil( (double)(max-min)/(double)(l-1) );
        if (avegap == 0) return 0;
        bucket[] buckets= new bucket[l];
        
        for(int i=0;i<l;i++) {
            buckets[i] = new bucket();
        }
        
        for (int i=0;i<l;i++) {
            int tmp = nums[i];
            int index = (tmp-min)/avegap;
            buckets[index].max = (buckets[index].max==-1)?tmp:( Math.max(tmp,buckets[index].max) );
            buckets[index].min = (buckets[index].min==-1)?tmp:( Math.min(tmp,buckets[index].min) );
        }
        
        int gap = 0;
        int pre = 0;
        
        /*for (int i=0;i<l;i++) {
            System.out.println("["+buckets[i].min+":"+buckets[i].max+"]");
        }*/
        
        for (int i=0;i<l;i++) {
            if (buckets[i].min==-1) continue;
            int tmpgap = buckets[i].min-buckets[pre].max;
            gap = Math.max(gap,tmpgap);
            pre = i;
        }
        return gap;
    }
}