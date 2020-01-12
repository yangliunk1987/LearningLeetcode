class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        is_negative = False
        if (dividend > 0 and divisor < 0) or (dividend < 0 and divisor > 0):
            is_negative = True
        dividend = abs(dividend)
        divisor = abs(divisor)
        runner, index = divisor, 1
        track = []
        while runner <= dividend:
            track.append((runner, index))
            runner = runner + runner
            index += index
        ret = 0
        for index in range(len(track) - 1, -1, -1):
            val, idx = track[index]
            if dividend >= val:
                dividend -= val
                ret += idx
        if (not is_negative and ret >= 2147483648) or (is_negative and ret > 2147483648):
            return 2147483647
        return ret if not is_negative else -ret
