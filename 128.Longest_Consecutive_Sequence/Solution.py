class Solution(object):
    def longestConsecutive(self, nums):

        n = len(nums)
        d = {}
        ans = 0
        for i in nums:
            if i not in d:
                left = d.get(i-1, 0)
                right = d.get(i+1, 0)
                length = left + right + 1
                ans = max(ans, length)

                d[i] = length
                d[i-left] = length
                d[i+right] = length

        return ans