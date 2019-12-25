class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mm = 0
        start = 0
        track = {}
        for i, c in enumerate(s):
            if c not in track:
                track[c] = i
                mm = max(mm, i - start + 1)
            else:
                prev = max(track[c], start - 1)
                curr_len = i - prev
                mm = max(mm, curr_len)
                start = prev + 1
                track[c] = i
        return mm