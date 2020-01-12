class Solution {
    public int numIslands(char[][] grid) {
            int count = 0;
            int rows = grid.length;
            if (rows == 0) {
                return 0;
            }
            int cols = grid[0].length;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == '1') {
                        count++;
                        bfs(r, c, rows, cols, grid);
                    }
                }
            }
            return count;
        }
    private void bfs(int r, int c, int rows, int cols, char[][] grid) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(r * cols + c);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int row = cur / cols;
                int col = cur % cols;
                //已经标记过就结束，这句很关键，不然会把一些节点重复加入
                if(grid[row][col] == '2'){
                    continue;
                }
                grid[row][col] = '2';
                //将上下左右连通的 1 加入队列
                if (row != (rows - 1) && grid[row + 1][col] == '1') {
                    queue.offer((row + 1) * cols + col);
                }
                if (col != (cols - 1) && grid[row][col + 1] == '1') {
                    queue.offer(row * cols + col + 1);
                }
                if (row != 0 && grid[row - 1][col] == '1') {
                    queue.offer((row - 1) * cols + col);
                }
                if (col != 0 && grid[row][col - 1] == '1') {
                    queue.offer(row * cols + col - 1);
                }

            }
    }
}