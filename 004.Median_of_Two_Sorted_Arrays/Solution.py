class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1,n2  = len(nums1), len(nums2)
        if n1 > n2:
            nums1, nums2, n1, n2 = nums2, nums1, n2, n1 #让nums2和n2更大

        imin, imax, half_len = 0, n1, (n1 + n2 + 1) // 2 #若为奇数，中位数算入half_len即左侧
        while imin <= imax: #二分查找的标准循环条件
            i = (imin + imax) // 2 #二分查找标准迭代条件.i为nums1分入左侧的个数
            j = half_len - i # j为nums2分入左侧的个数
            if j > 0 and i < n1 and nums1[i] < nums2[j-1]: # i太小
                imin = i + 1
            elif i > 0 and j < n2 and nums1[i-1] > nums2[j]: # i太大
                imax = i - 1
            else:
                # 结果已经得出
                if i == 0: max_of_left = nums2[j-1] #所有的nums1大于nums2
                elif j == 0: max_of_left = nums1[i-1]
                else: max_of_left = max(nums1[i-1], nums2[j-1])

                if (n1 + n2) % 2 == 1: #如果总数为奇数 中位数在half_len末尾即左侧末尾
                    return max_of_left

                if i == n1: min_of_right = nums2[j]
                elif j == n2: min_of_right = nums1[i]
                else: min_of_right = min(nums1[i], nums2[j])

                return (max_of_left + min_of_right) / 2.0