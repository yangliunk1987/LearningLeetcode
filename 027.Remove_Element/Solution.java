public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int curr = 0;
        int runner = 0;
        while (runner < nums.length) {
            if (nums[runner] != val) {
                nums[curr] = nums[runner];
                curr++;
            }
            runner++;
        }
        
        return curr;
    }
}
