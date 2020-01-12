public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        } else if (nums.length <= 1) {
            return 1;
        }
        int curr = 0;
        int runner = 1;
        while (runner < nums.length) {
            if (nums[runner] != nums[curr]) {
                curr++;
                nums[curr] = nums[runner];
            }
            runner++;
        }
        
        return curr+1;
    }
}
