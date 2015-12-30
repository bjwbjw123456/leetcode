public class NumArray {
    int[] data;

    public NumArray(int[] nums) {
        int l = nums.length;
        int sum = 0;
        data = new int[l];
        for (int i=0;i<l;i++) {
            sum+=nums[i];
            data[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return data[j];
        return data[j] - data[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);