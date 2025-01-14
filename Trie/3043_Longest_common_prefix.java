class Solution {
    class TrieNode{
        char ch;
        TrieNode[]children;
    } 
    public TrieNode root;
    public TrieNode getNode(){
        TrieNode temp = new TrieNode();
        temp.children = new TrieNode[10];

        for(int i=0;i<10;i++){
            temp.children[i] = null;
        }
        return temp;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = getNode();
        for(int val:arr1){
            insert(root,val);
        }
        int result = 0;
        for(int val:arr2){
            result = Math.max(result, search(root, val));
        }
        return result;
    }
    public void insert(TrieNode root, int val){
        TrieNode pointer = root;
        //Integer.toString(number)
        String strval = String.valueOf(val);
        for(char ch: strval.toCharArray()){
            int index = ch-'0';
            if(pointer.children[index] == null){
                pointer.children[index] = getNode();
            }
            pointer = pointer.children[index];
        }
    }
    public int search(TrieNode root, int val){
        TrieNode pointer = root;
        int length = 0;
        String strval = String.valueOf(val);

        for(char ch:strval.toCharArray()){
            int index = ch-'0';
            if(pointer.children[index]!=null){
                pointer = pointer.children[index];
                length++;
            }
            else{
                break;
            }
        }
        return length;
    }
}
