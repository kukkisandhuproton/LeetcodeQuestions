class Solution {
    int rows;
    int columns;
    List<String> result = new ArrayList<>();


    class TrieNode{
        char ch;
        TrieNode[] children;
        boolean eow;
        String word;
        public TrieNode(char ch){
            this.ch = ch;
            this.children = new TrieNode[26];
            this.eow = false;
            this.word = "";
        }
    }
    private TrieNode root;
    public TrieNode getNode(char ch){
        TrieNode temp = new TrieNode(ch);
        for(int i=0;i<26;i++){
            temp.children[i] = null;
        }
        temp.eow = false;
        temp.word = "";
        return temp;
    }
    public void insert(TrieNode root, String word){
        TrieNode pointer = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(pointer.children[c-'a'] == null){
                pointer.children[c-'a'] = getNode(c);
            }
            pointer = pointer.children[c-'a'];
        }
        pointer.eow = true;
        pointer.word = word;
    }
    public void dfs(char[][]board, int i, int j, TrieNode root){
        if(i<0 || i>=rows || j<0 ||j>=columns|| board[i][j] == '*'){
            return;
        }
        int index = board[i][j] - 'a';
        if(root.children[index] == null){
            return;
        }
        root = root.children[index];
        if(root.eow){
            result.add(root.word);
            root.eow = false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        int[] d1 = {-1,0, 1, 0};
        int[] d2 = {0,1,0, -1};
        for(int d =0;d<d1.length; d++){
            int new_i = i+d1[d];
            int new_j = j+d2[d];
            dfs(board,new_i, new_j, root);
        }
        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        columns = board[0].length;
        if( board == null || rows == 0 ){
            return null;
        }
        root = getNode('0');
        for(String word: words){
            insert(root, word);
        }
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                char c = board[i][j];
                int index = c- 'a';
                if(root.children[index] != null){
                    dfs(board, i, j, root);
                }
            }
        }
        return result;
    }

}
