class Solution {
    int rows;
    int columns;
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int maxSum = 0;

        if(grid == null || rows == 0){
            return maxSum;
        }
        for(int row = 0; row<rows; row++){
            for(int column = 0; column<columns; column++){
                if(grid[row][column]!= 0){
                    maxSum = Math.max(maxSum, dfs(grid, row, column));
                }
            }
        }
        return maxSum;
    }
    public int dfs(int[][] grid, int row, int column){
        if(row<0 || column<0 || row>=rows || column>=columns || grid[row][column] == 0 || grid[row][column] == '*'){
            return 0;
        }

        int current = grid[row][column];
        int temp = grid[row][column];
        grid[row][column] = '*';
        int[] d1 = {0, -1, 1, 0};
        int[] d2 = {-1, 0, 0, 1};
        int max = 0;
        for(int d = 0; d<d1.length; d++){
            int new_row = row+d1[d];
            int new_column = column+d2[d];
            max = Math.max(max,dfs(grid, new_row, new_column));
        }
        grid[row][column] = temp;
        return current + max;
    }
}
