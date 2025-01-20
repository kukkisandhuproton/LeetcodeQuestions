//Time Complexity => O(m*n*3^l) because from each specific point you can go into the 3 direction and then you can explore till string of the length
//Space Complexity => O(l)  because this will be the length of the recursion stack.   
class Solution {
    int rows;
    int columns;
    public boolean exist(char[][] board, String word) {
        if( board == null || board.length == 0){
            return false;
        }
        rows = board.length;
        columns = board[0].length;

        for(int i = 0; i<rows;i++){
            for(int j=0;j<columns;j++){
                char ch = board[i][j];
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]board, int i, int j, String word, int index)
    {
    if(index == word.length()){
        return true;
    }
    if(i<0 || i>=rows || j<0 || j>=columns || board[i][j] == '*' || board[i][j]!=word.charAt(index)){
        return false;
    }

    char temp = board[i][j];
    board[i][j] = '*';
    int[] d1 = {0,1, 0, -1};
    int[] d2 = {1, 0, -1, 0};

    for(int d=0;d<d1.length;d++){
        int new_i = i+d1[d];
        int new_j = j+d2[d];
        if(dfs(board, new_i, new_j,word, index+1)){
            return true;
        }
    }
    board[i][j] = temp;
    return false;
}
}
