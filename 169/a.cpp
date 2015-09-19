class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        int now = nums[0];
        int count = 0;
        vector <int>::iterator iter;
        for (int i = 0;i<nums.size();i++) {
            if (nums[i] == now) {
                count++;
            }  else {
                if (count>0) {
                    count--;
                } else {
                    now = nums[i];
                    count = 1;
                }
            }
            
        }
        return now;
        
    }
};
