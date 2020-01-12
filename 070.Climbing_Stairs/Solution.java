class Solution {
    public int climbStairs(int n) {
        int[][] Q = {{1, 1}, {1, 0}};
        int[][] res = pow(Q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            //最后一位是 1，加到累乘结果里
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            //n 右移一位
            n >>= 1;
            //更新 a
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}