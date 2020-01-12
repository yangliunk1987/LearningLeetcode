class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        s_index, p_index = 0, 0
        star, s_star = -1, 0
        s_len, p_len = len(s), len(p)
        while s_index < s_len:
            if p_index < p_len and (s[s_index] == p[p_index] or p[p_index] == '?'):
                s_index += 1
                p_index += 1
            elif p_index < p_len and p[p_index] == '*':
                star = p_index
                s_star = s_index
                p_index += 1
            elif star != -1:
                p_index = star + 1
                s_star += 1
                s_index = s_star
            else:
                return False
        while p_index < p_len and p[p_index] == '*':
            p_index += 1
        return p_index == p_len