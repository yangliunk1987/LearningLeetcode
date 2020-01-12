class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int bit_nums = nums.length;
        int ans_nums = 1 << bit_nums; //执行 2 的 n 次方
        for (int i = 0; i < ans_nums; i++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0; //记录当前对应数组的哪一位
            int i_copy = i; //用来移位
            while (i_copy != 0) { 
                if ((i_copy & 1) == 1) { //判断当前位是否是 1
                    tmp.add(nums[count]);
                }
                count++;
                i_copy = i_copy >> 1;//右移一位
            }
            ans.add(tmp);

        }
        return ans;
    }
}