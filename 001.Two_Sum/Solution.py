class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        track = {}
        for i, n in enumerate(nums):
            if n not in track:
                track[n] = [i]
            else:
                track[n].append(i)
        for k in track:
            left = target - k
            if left not in track:
                continue
            if left == k and len(track[k]) == 1:
                continue
            elif left == k:
                return track[k]
            return [track[k][0], track[left][0]]