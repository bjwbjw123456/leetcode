public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length<=1) return nums;
        
        Comparator<Integer> cmp = new Comparator<Integer>(){
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        
        Queue<Integer> heap = new PriorityQueue<Integer>(k, cmp);
        int[] r = new int[nums.length-k+1];
        
        for (int i=0;i<k-1;i++) {
            heap.add(nums[i]);
        }
        
        for (int i=0;i<nums.length-k+1;i++) {
            heap.add(nums[i+k-1]);
            if(i>0) {
                heap.remove(nums[i-1]);
            }
            r[i] = heap.peek();
        }
        return r;
    }
}