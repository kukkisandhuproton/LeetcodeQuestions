class Solution {
    class TrieNode{
        char ch;
        boolean eow;
        TrieNode[] children;
        String word;

        public TrieNode(char ch){
            this.ch = ch;
            this.eow = false;
            this.word = "";
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public TrieNode getNode(char ch){
        TrieNode temp = new TrieNode(ch);
        temp.eow = false;
        for(int i=0;i<26;i++){
            temp.children[i] = null;
        }
        temp.word = "";
        return temp;
    }
    public void insert(TrieNode root, String str){
        TrieNode pointer = root;
        for(char c:str.toCharArray()){
            int index = c-'a';
            if(pointer.children[index] == null){
                pointer.children[index] = getNode(c);
            }
            pointer = pointer.children[index];
        }
        pointer.eow = true;
        pointer.word = str;
    }
    public String search(TrieNode root, String str){
        TrieNode pointer = root; 
        for(char c:str.toCharArray()){
            int index = c-'a';
            if(root.children[index] == null){
                return str;
            }
            else if(root.children[index].eow){
                return root.children[index].word;
            }
            else{
                root = root.children[index];
            }
        }
        return str;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = getNode('0');
        String[] strs = sentence.split(" ");
        for(String str:dictionary){
            insert(root, str);
        }
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(search(root,str));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
