from random import randint

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 改进的快排
        def quick_sort(left, right, nums):
            l, r = left, right
            index = randint(l, r)
            nums[l], nums[index] = nums[index], nums[l]
            while l < r:
                while l < r:
                    if nums[r] < nums[l]:
                        nums[l], nums[r] = nums[r], nums[l]
                        l += 1
                        while l < r:
                            if nums[l] > nums[r]:
                                nums[l], nums[r] = nums[r], nums[l]
                                r -= 1
                                break
                            else:
                                l += 1
                    else:
                        r -= 1

            if l == len(nums) - k:
                return nums[l]
            elif l > len(nums) - k:
                return quick_sort(left, l - 1, nums)
            else:
                return quick_sort(l + 1, right, nums)

        return quick_sort(0, len(nums) - 1, nums)