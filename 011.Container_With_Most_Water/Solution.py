class Solution:
    def maxArea(self, heights: List[int]) -> int:
        start, end = 0, len(heights) - 1
        mm = None
        while start < end:
            area = min(heights[start], heights[end]) * (end - start)
            if mm is None or area > mm:
                mm = area
            if heights[start] < heights[end]:
                start += 1
            else:
                end -= 1
        return mm