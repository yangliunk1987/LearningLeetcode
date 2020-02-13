class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int fast = 2;
        int max = 2;
        for (; fast < nums.length; fast++) {
            //不相等的话就添加
            if (nums[fast] != nums[slow - max + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}