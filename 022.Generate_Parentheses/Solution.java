public class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList();
    if (n == 0) {
        ans.add("");
    } else {
        for (int a = 0; a < n; a++)
            for (String left: generateParenthesis(a))
                for (String right: generateParenthesis(n-1-a))
                    ans.add("(" + left + ")" + right);
    }
    return ans;
}
}