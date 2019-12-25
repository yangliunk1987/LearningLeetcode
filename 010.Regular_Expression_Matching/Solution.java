class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[2][pattern.length() + 1]; 
        dp[text.length()%2][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                if(i==text.length()&&j==pattern.length()) continue;
                boolean first_match = (i < text.length() && j < pattern.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i%2][j] = dp[i%2][j + 2] || first_match && dp[(i + 1)%2][j];
                } else {
                    dp[i%2][j] = first_match && dp[(i + 1)%2][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}