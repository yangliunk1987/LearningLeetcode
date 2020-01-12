class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums)
        if length == 0:
            return [-1,-1]
        if nums[0] <= target and nums[-1] >= target:
            left,right = 0,length-1

            while left <= right:
                mid = (left+right) // 2

                if nums[mid] == target:
                    right = left = mid

                    while left-1 >= 0 and nums[left-1] == target:
                        left -= 1
                    while right+1 <= length-1 and nums[right+1] == target:
                        right += 1
                    return [left,right]

                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1

        return [-1,-1]