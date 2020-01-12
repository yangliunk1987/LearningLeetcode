class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int pre = 0; //代替上边代码中的 nums[i - 2]
        int cur = nums[0]; //代替上边代码中的 nums[i - 1] 和 nums[i]
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i - 1], cur);
            pre = temp;
        }
        return cur;
    }
}