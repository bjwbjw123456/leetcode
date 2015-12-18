public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] r = new int[m+n];
        if (m == 0){
            for(int i = 0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        
        int i =0;
        int j =0;
        int k =0;
        while(i<m){
            int t1 = nums1[i];
            int t2 = nums2[j];
            if (t1<t2) {
                r[k] = t1;
                i++;
            } else {
                r[k] = t2;
                j++;
                
            }
            k++;
            if(j >= n) {
                break;
            }
        }
        
        if (i < m) {
            for (;i<m;i++,k++) {
                r[k] = nums1[i];
            }
        }
        
        if (j<n) {
            for (;j<n;j++,k++) {
                r[k] = nums2[j];
            }
        }
        for (i = 0; i<m+n;i++){
            nums1[i] = r[i];
        }
        
        return;
    }
}