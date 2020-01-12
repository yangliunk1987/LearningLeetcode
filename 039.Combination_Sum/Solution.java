class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<List<Integer>>> ans = new ArrayList<>();
    Arrays.sort(nums);
    if (nums[0] > target) {
        return new ArrayList<List<Integer>>();
    }
    // 先初始化 ans[0] 到 ans[target]，因为每次循环是更新 ans,会用到 ans.get() 函数，如果不初始化会报错
    for (int i = 0; i <= target; i++) {
        List<List<Integer>> ans_i = new ArrayList<List<Integer>>();
        ans.add(i, ans_i);
    }

    for (int i = 0; i < nums.length; i++) {
        for (int sum = nums[i]; sum <= target; sum++) {
            List<List<Integer>> ans_sum = ans.get(sum);
            List<List<Integer>> ans_sub = ans.get(sum - nums[i]);
            //刚开始 ans_sub 的大小是 0，所以单独考虑一下这种情况
            if (sum == nums[i]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                ans_sum.add(temp);

            }
            //如果 ans.get(sum - nums[i])大小不等于 0，就可以按之前的想法更新了。
            //每个 ans_sub[j] 都加上 nums[i]
            if (ans_sub.size() > 0) {
                for (int j = 0; j < ans_sub.size(); j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(ans_sub.get(j));
                    temp.add(nums[i]);
                    ans_sum.add(temp);
                }
            }
        }
    }
    return ans.get(target);
}
}