class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1 = self.convert(num1)
        n2 = self.convert(num2)
        return str(n1 * n2)
    def convert(self, num):
        n = len(num)
        i = 0
        val = 0
        ord_zero = ord('0')
        while i < n:
            val = val * 10 + (ord(num[i]) - ord_zero)
            i += 1

        return val