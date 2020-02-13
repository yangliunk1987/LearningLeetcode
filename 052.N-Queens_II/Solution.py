class Solution(object):
    def __init__(self):
        self.count = 0

    def totalNQueens(self, n):
        self.dfs(0, n, 0, 0, 0)
        return self.count

    def dfs(self, row, n, column, diag, antiDiag):
        if row == n:
            self.count += 1
            return
        for index in range(n):
            # column check
            isColSafe = (1 << index) & column == 0
            # diagonal, all nodes have the same n - 1 + row - index
            isDigSafe = (1 << (n - 1 + row - index)) & diag == 0
            # anti diagonal, all nodes have the same row + index
            isAntiDiagSafe = (1 << (row + index)) & antiDiag == 0
            if isAntiDiagSafe and isColSafe and isDigSafe:
                self.dfs(row + 1,  n, (1 << index) | column,
                         (1 << (n - 1 + row - index)) | diag,
                         (1 << (row + index)) | antiDiag)