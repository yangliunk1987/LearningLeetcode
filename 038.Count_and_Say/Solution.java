class Solution {
    public String countAndSay(int n) {
    String res = "1";
    //从第一行开始，一行一行产生
    while (n > 1) {
        String temp = "";
        for (int i = 0; i < res.length(); i++) {
            int num = getRepeatNum(res.substring(i));
            temp = temp + num + "" + res.charAt(i);
            //跳过重复的字符
            i = i + num - 1;
        }
        n--;
        //更新
        res = temp;
    }
    return res;

    }
//得到字符 string[0] 的重复个数，例如 "111221" 返回 3
    private int getRepeatNum(String string) {
        int count = 1;
        char same = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (same == string.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}