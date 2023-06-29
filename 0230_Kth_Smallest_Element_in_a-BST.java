lass Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null) {
            s.add(root);
            root = root.left;
        }
        
        return kthSmallestUtil(s, k);
    }
    
    public int kthSmallestUtil(Stack<TreeNode> s, int k) {
        while(!s.isEmpty() && k > 0) {
            if(k == 1) {
                return s.pop().val;
            }

            TreeNode currNode = s.pop().right;
            
            while(currNode != null) {
                s.add(currNode);
                currNode = currNode.left;
            }
            
            k--;
        }

        return Integer.MIN_VALUE;
    }
}
