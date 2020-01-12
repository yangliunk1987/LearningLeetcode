class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals
        intervals.sort()
        res = []
        for i in range(len(intervals)):
            if res == []:
                res.append(intervals[i])
            else:
                if res[-1][1] >= intervals[i][0]:
                    res[-1][1] = max(intervals[i][1], res[-1][1])
                else:
                    res.append(intervals[i])
        return res