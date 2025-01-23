class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        if( n == 0 || requests.length == 0){
            return 0;
        }
        return backtrack(0, n, requests, 0, indegree);
    }

    public int backtrack(int index, int n, int[][]requests, int count, int[] indegree){
        if(index >= requests.length){
            for(int i = 0; i<indegree.length; i++){
                if(indegree[i]!=0){
                    return 0;
                }
            }
            return count;
        }
        // take the request in
        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;
        int take = backtrack(index+1, n, requests, count+1, indegree);
        // not to take the move
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;
        int nottake = backtrack(index+1, n, requests, count, indegree);

        return Math.max(take, nottake);
    }
}
