class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[] ans = new int[word2.length() + 1];

        for (int i = 0; i <= word2.length(); i++) {
            ans[i] = i;
        }
        int n1 = word1.length();
        int n2 = word2.length();
        for (int i = 1; i <= n1; i++) {
            int temp = ans[0];
            ans[0] = ans[0] + 1;
            for (int j = 1; j <= n2; j++) {
                int min_delete = Math.min(ans[j], ans[j - 1]) + 1;
                //上一列的上一个位置，直接用 temp
                int replace = temp;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace++;
                }
                //保存当前列的信息
                temp = ans[j];
                //再进行更新
                ans[j] = Math.min(min_delete, replace);
            }
        }
        return ans[n2];
    }
}