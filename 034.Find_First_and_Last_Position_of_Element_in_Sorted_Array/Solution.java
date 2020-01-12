class Solution {
    public int[] searchRange(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int[] ans = { -1, -1 };
    if (nums.length == 0) {
        return ans;
    }
    while (start <= end) {
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            end = mid - 1;
        } else if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    //考虑 tartget 是否存在，判断我们要找的值是否等于 target 并且是否越界
    if (start == nums.length || nums[ start ] != target) {
        return ans;
    } else {
        ans[0] = start;
    }
    ans[0] = start;
    start = 0;
    end = nums.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            start = mid + 1;
        } else if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    ans[1] = end;
    return ans;
}
}