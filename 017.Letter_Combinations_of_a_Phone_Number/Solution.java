public class Solution {
    public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<String>();
    for (int i = 0; i < digits.length(); i++) {
        ans = mul(ans, getList(digits.charAt(i) - '0'));
    }
    return ans;

}

public List<String> getList(int digit) {
        String digitLetter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < digitLetter[digit].length(); i++) {
            ans.add(digitLetter[digit].charAt(i) + "");
        }
        return ans;
    }
public List<String> mul(List<String> l1, List<String> l2) {
    if (l1.size() != 0 && l2.size() == 0) {
        return l1;
    }
    if (l1.size() == 0 && l2.size() != 0) {
        return l2;
    }
    List<String> ans = new ArrayList<String>();
    for (int i = 0; i < l1.size(); i++)
        for (int j = 0; j < l2.size(); j++) {
            ans.add(l1.get(i) + l2.get(j));
        }
    return ans;
}
}