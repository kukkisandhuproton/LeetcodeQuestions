class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if( n == 0){
            return result;
        }
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }
    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> current, int index){
        if( current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index>n){
            return;
        }
        current.add(index);
        backtrack(n, k, result, current, index+1);
        current.remove(current.size()-1);
        backtrack(n, k, result, current, index+1);
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if( n == 0){
            return result;
        }
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }
    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> current, int index){
        if( current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index>n){
            return;
        }

        for(int i = index; i<n+1; i++){
            current.add(i);
            backtrack(n, k, result, current, i+1);
            current.remove(current.size()-1);
        }

    }
}
