public class Solution {
    public int strStr(String haystack, String needle) {
        int runner = 0;
        boolean found = false;
        boolean matching = true;
        while (needle.length() + runner <= haystack.length()) {
            matching = true;
            for (int i = 0; i < needle.length(); i++) {
                if (needle.charAt(i) != haystack.charAt(i + runner)) {
                    matching = false;
                    break;
                }
            }
            if (matching) {
                found = true;
                break;
            }
            runner++;
        }
        
        return found ? runner : -1;
    }
}
