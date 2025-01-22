class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int[]nums, int index, ArrayList<Integer> curr, List<List<Integer>> result){
        if(curr.size()>1){
            result.add(new ArrayList<>(curr));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = index; i<nums.length;i++){
            if((curr.size() == 0|| nums[i]>=curr.get(curr.size()-1)) && !set.contains(nums[i])){
            // if((curr.size() ==0 || nums[i] >= curr.get(curr.size()-1)) && !used.contains(nums[i])) {

                // set.add(nums[i]);
                // curr.add(nums[i]);
                // backtrack(nums,i+1,curr,result);
                // curr.remove(curr.size()-1);
                set.add(nums[i]);
                
                curr.add(nums[i]); 
                
                backtrack(nums, i+1, curr, result);
                
                curr.remove(curr.size()-1);
            }
        }

    }
}
