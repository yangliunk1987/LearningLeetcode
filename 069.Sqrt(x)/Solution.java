class Solution {
    //计算 x² - n
    public double fx(double x, double n) {
        return x * x - n;
    }

    public int mySqrt(int n) {
        double low = 0;
        double high = n;
        double mid = (low + high) / 2;
        //函数值小于 0.1 的时候结束
        while (Math.abs(fx(mid, n)) > 0.1) {
            //左端点的函数值
            double low_f = fx(low, n);
            //中间节点的函数值
            double low_mid = fx(mid, n);
            //判断哪一段的函数值是异号的
            if (low_f * low_mid < 0) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        //先进行四舍五入
        int ans = (int) Math.round(mid);
        if (ans != 0 && ans > n / ans) {
            ans--;
        }
        return ans;
    }
}