class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<List<Integer>>> ans = new ArrayList<>(); //opt 数组
    Arrays.sort(nums);// 将数组有序，这样可以提现结束循环
    for (int sum = 0; sum <= target; sum++) { // 从 0 到 target 求出每一个 opt
        List<List<Integer>> ans_sum = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) { //遍历 nums
            /*******************修改的地方********************/
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            /***********************************************/
            if (nums[i] == sum) { 
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                ans_sum.add(temp);
            } else if (nums[i] < sum) {
                List<List<Integer>> ans_sub = ans.get(sum - nums[i]);
                //每一个加上 nums[i]
                for (int j = 0; j < ans_sub.size(); j++) {
                    List<Integer> temp = new ArrayList<Integer>(ans_sub.get(j));
                    temp.add(nums[i]);
                    ans_sum.add(temp);
                }
            } else {
                break;
            }
        }
        ans.add(sum, ans_sum);
    }
    return remove(removeDuplicate(ans.get(target)),nums);
	} 

	private List<List<Integer>> removeDuplicate(List<List<Integer>> list) {
	    Map<String, String> ans = new HashMap<String, String>();
	    for (int i = 0; i < list.size(); i++) {
	        List<Integer> l = list.get(i);
	        Collections.sort(l);
	        String key = "";
	        //[ 2 3 4 ] 转为 "2,3,4"
	        for (int j = 0; j < l.size() - 1; j++) {
	            key = key + l.get(j) + ",";
	        }
	        key = key + l.get(l.size() - 1);
	        ans.put(key, "");
	    }
    //根据逗号还原 List
	    List<List<Integer>> ans_list = new ArrayList<List<Integer>>();
	    for (String k : ans.keySet()) {
	        String[] l = k.split(",");
	        List<Integer> temp = new ArrayList<Integer>();
	        for (int i = 0; i < l.length; i++) {
	            int c = Integer.parseInt(l[i]);
	            temp.add(c);
	        }
	        ans_list.add(temp);
	    }
	    return ans_list;
	}

//过滤不满足答案的情况
	private List<List<Integer>> remove(List<List<Integer>> list, int[] nums) {
	    HashMap<Integer, Integer> nh = new HashMap<Integer, Integer>();
	    List<List<Integer>> ans = new ArrayList<List<Integer>>(list);
	    //记录每个数字出现的次数
	    for (int n : nums) {
	        int s = nh.getOrDefault(n, 0);
	        nh.put(n, s + 1);
	    }
	    for (int i = 0; i < list.size(); i++) {
	        List<Integer> l = list.get(i);
	        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
	        //记录每个 list 中数字出现的次数
	        for (int n : l) {
	            int s = temp.getOrDefault(n, 0);
	            temp.put(n, s + 1);
	        }
	        for (int n : l) {
	            //进行比较
	            if (temp.get(n) > nh.get(n)) {
	                ans.remove(l);
	                break;
	            }
	        }
	    }
	    return ans;
	}
}