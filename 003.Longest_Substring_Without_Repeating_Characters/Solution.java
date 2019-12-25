public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0, l=0, last_index=0;
        HashMap <Character,Integer> map = new HashMap <Character,Integer>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                l++;
                if(l>ans) ans=l;
                map.put(s.charAt(i),i);
            }
            else{
                if(last_index<=map.get(s.charAt(i))){
                    last_index = map.get(s.charAt(i))+1;
                }
                l = i-last_index+1;
                if(l>ans) ans=l;
                map.put(s.charAt(i),i);
            }
        }
        return ans;
    }
}