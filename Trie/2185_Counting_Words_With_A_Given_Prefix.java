/*
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word:words){
            if(word.indexOf(pref) == 0){
                count++;
                //&& word.subsring(pref.length()).equals(perf
            }
        }
        return count;
    }
}
*/
class Solution {
    class TrieNode{
        char ch;
        boolean eow;
        TrieNode[] children;
        int count;

        public TrieNode(char ch){
            this.ch = ch;
            this.eow = false;
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }
    private TrieNode root;
    public TrieNode getNode(char ch){
        TrieNode temp = new TrieNode(ch);
        temp.eow = false;
        temp.count = 0;
        for(int i=0;i<26;i++){
            temp.children[i] = null;
        }
        return temp;
    }
    public void insert(TrieNode root, String word){
        TrieNode pointer = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(pointer.children[index] == null){
                pointer.children[index] = getNode(c);
            }
            pointer = pointer.children[index];
            pointer.count++;
        }
        pointer.eow = true;
    }
    public int search(TrieNode root, String perf){
        TrieNode pointer = root;
        for(char c:perf.toCharArray()){
            int index = c-'a';
            if(pointer.children[index]==null){
                return 0;
            }
            pointer = pointer.children[index];
        }
        return pointer.count;
    }
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        root = new TrieNode('0');
        for(String word:words){
            insert(root, word);
        }
        return search(root, pref);
    }
}
