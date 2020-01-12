class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        //从下标 0 开始的所有组合
        upset(nums, 0, all);
        return all;
    }

    private void upset(int[] nums, int begin, List<List<Integer>> all) {
        if (begin == nums.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(); 
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            all.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            upset(nums, begin + 1, all);
            swap(nums, i, begin);
        }

    }

    private void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }
}