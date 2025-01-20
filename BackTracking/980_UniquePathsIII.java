// Time Complexity => O(3^m*n) => each member can be called three time
// Space Complexity => O(m*n)
class Solution {
    int rows;
    int columns;
    public int uniquePathsIII(int[][] grid) {
        int start_x = 0;
        int start_y = 0;
        int empty = 1;
        rows = grid.length;
        columns = grid[0].length;
        if(grid == null || grid.length == 0){
            return 0;
        }

        for(int row = 0; row<rows; row++){
            for(int column = 0; column<columns;column++){
                if(grid[row][column] == 0){
                    empty++;
                }
                if(grid[row][column] == 1){
                    start_x = row;
                    start_y = column;
                }
            }
        }
        return dfs(grid, start_x, start_y, 0, empty);
    }

    public int dfs(int[][]grid, int row, int column, int count, int empty){
        
        if(row<0 || row>=rows || column<0 || column>=columns || grid[row][column] == -1){
            return 0;
        }
        if(grid[row][column] == 2 && empty == count){
            return 1;
        }
        else if( grid[row][column] == 2){
            return 0;
        }
        grid[row][column] = -1;
        int[] d1 = {0,1,0, -1};
        int[] d2 = {1, 0, -1, 0};
        int result = 0;
        for(int i = 0; i<d1.length; i++){
            int new_row = row + d1[i];
            int new_column = column + d2[i];
            result += dfs(grid, new_row, new_column, count+1, empty);
        }


        grid[row][column] = 0;
        System.out.println("Result is "+ result);
        return result;
    }
}
