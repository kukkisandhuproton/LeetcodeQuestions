class Trie {
    class TrieNode{
        char ch;
        TrieNode[]children;
        boolean eow;
        public TrieNode(char ch){
            this.ch = ch;
            this.children = new TrieNode[26];
            this.eow = false;
        }
    }
    private TrieNode root;
    public TrieNode getNode(char ch){
        TrieNode temp = new TrieNode(ch);
        for(int i=0;i<26;i++){
            temp.children[i] = null;
        }
        temp.eow = false;
        return temp;
    }
    public Trie() {
        root = getNode('0');
    }
    
    public void insert(String word) {
        TrieNode pointer = root;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(pointer.children[index] == null){
                pointer.children[index] = getNode(ch);
            }
            pointer = pointer.children[index];
        }
        pointer.eow = true;
    }
    
    public boolean search(String word) {
        TrieNode pointer = root;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(pointer.children[index] == null){
                return false;
            }
            pointer = pointer.children[index];
        }
        return pointer.eow;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        int count = 0;
        for(char ch:prefix.toCharArray()){
            int index = ch - 'a';
            if(pointer.children[index]== null){
                return false;
            }
            pointer = pointer.children[index];
            count++;
        }
        if(prefix.length() == count){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
