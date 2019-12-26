public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return -1;  // should throw exception probably
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[2] + nums[1];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int temp;
            while (start < end) {
                temp = nums[start] + nums[end] + nums[i];
                if (temp - target == 0) {
                    return target;
                } else if (temp - target < 0) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(temp - target) < Math.abs(closest - target)) {
                    closest = temp;
                }
            }
        }
        
        return closest;
    }
}