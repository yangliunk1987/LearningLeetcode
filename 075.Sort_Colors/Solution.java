class Solution {
    public void sortColors(int[] nums) {
        int zero_count = 0;
        int one_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero_count++;
            }
            if (nums[i] == 1) {
                one_count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero_count > 0) {
                nums[i] = 0;
                zero_count--;
            } else if (one_count > 0) {
                nums[i] = 1;
                one_count--;
            } else {
                nums[i] = 2;
            }
        }
    }
}