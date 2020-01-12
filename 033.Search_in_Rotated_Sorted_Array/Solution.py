class Solution(object):
    def search(self, nums, target):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low + high) // 2
            print(low,high,mid)

            if nums[mid] == target:
                return mid
            elif high==low:
                return -1
            elif nums[mid] <= nums[low] and nums[mid] <= nums[high] and nums[mid-1] >= nums[mid]:#mid is pivot

                if target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            elif nums[mid] > nums[mid-1] and nums[high] > nums[mid]: #pivot to left of mid\
                if nums[mid] > nums[low]: #pivot at start index

                    if target < nums[mid]:
                        high = mid - 1
                    else:
                        low = mid + 1
                else:
                    if target > nums[mid] and target <= nums[high]:
                        low = mid + 1
                    elif target < nums[mid] or target >= nums[low]:
                        high = mid - 1
                    else:
                        return -1
            elif nums[mid] >= nums[low] and nums[high] <= nums[mid]: #pivot to right of mid
                if target <= nums[high] or target > nums[mid] :
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                    return -1
        return -1