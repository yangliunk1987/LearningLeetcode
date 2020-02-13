class Solution {
/*
 * direction 0 代表向右, 1 代表向下, 2 代表向左, 3 代表向上
*/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0){
            return ans;
        }
        int start_x = 0, 
        start_y = 0,
        direction = 0, 
        top_border = -1,  //上边界
        right_border = matrix[0].length,  //右边界
        bottom_border = matrix.length, //下边界
        left_border = -1; //左边界
        while(true){
            //全部遍历完结束
            if (ans.size() == matrix.length * matrix[0].length) {
                return ans;
            }
            //注意 y 方向写在前边，x 方向写在后边
            ans.add(matrix[start_y][start_x]);
            switch (direction) {
                //当前向左
                case 0:
                    //继续向左是否到达边界
                    //到达边界就改变方向，并且更新上边界
                    if (start_x + 1 == right_border) {
                        direction = 1;
                        start_y += 1;
                        top_border += 1;
                    } else {
                        start_x += 1;
                    }
                    break;
                //当前向下
                case 1:
                    //继续向下是否到达边界
                    //到达边界就改变方向，并且更新右边界
                    if (start_y + 1 == bottom_border) {
                        direction = 2;
                        start_x -= 1;
                        right_border -= 1;
                    } else {
                        start_y += 1;
                    }
                    break;
                case 2:
                    if (start_x - 1 == left_border) {
                        direction = 3;
                        start_y -= 1;
                        bottom_border -= 1;
                    } else {
                        start_x -= 1;
                    }
                    break;
                case 3:
                    if (start_y - 1 == top_border) {
                        direction = 0;
                        start_x += 1;
                        left_border += 1;
                    } else {
                        start_y -= 1;
                    }
                    break;
            }
        }

    }
}