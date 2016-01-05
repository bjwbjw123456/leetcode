public class Solution {

    private void helper(int[] nums, int target, int head, int tail, int[] position){
        //System.out.println(""+head+","+tail+"["+position[0]+":"+position[1]+"]");
        if (nums[head] == nums[tail]) {
            if (nums[head] == target) {
                position[0] = (position[0]==-1)?head:( Math.min(position[0],head) );
                position[1] = (position[1]==-1)?tail:( Math.max(position[1],tail) );
            }
            return;
        }
        
        int middle = head+(tail-head)/2;
        
        if (nums[middle]<target){
            helper(nums,target,middle+1,tail,position);
        } else if (nums[middle]>target) {
            helper(nums,target,head,middle,position);
        } else {
            position[0] = (position[0]==-1)?middle:Math.min(middle,position[0]);
            position[1] = (position[1]==-1)?middle:Math.max(middle,position[1]);
            helper(nums,target,middle+1,tail,position);
            helper(nums,target,head,middle,position);
        }
        
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] position = new int[]{-1,-1};
        if (nums == null || nums.length==0) return position;
        int head = 0;
        int tail = nums.length-1;
        helper(nums,target,head,tail,position);
        return position;
    }
}