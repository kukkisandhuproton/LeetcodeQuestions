class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row= box.length;
        int column = box[0].length;
        char[][] result = new char[column][row];
        for(int i =0;i<row;i++){
            for(int j=column-1;j>=0;j--){
                if(box[i][j]=='#'){

                
                int currentcolumn = j;
                while(currentcolumn+1<column && box[i][currentcolumn+1]=='.'){
                    currentcolumn++;
                }
                if(currentcolumn!=j){
                    box[i][currentcolumn]='#';
                    box[i][j]='.';
                }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println(row-1-i+","+i+","+j);
                result[j][i] = box[row-1-i][j];
            }
        }
        return result;
    }
}


/*
Row = 1
Column = 4


Row
0,0  -> 1,0
0,1  -> 1,0 
0,2  -> 2,0

1,0. -> 0,1
1,2  -> 2,1
1,3  -> 3,1
1,4  -> 4,1



*/
