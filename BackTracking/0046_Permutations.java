class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        solve(nums, result, new ArrayList<>(), 0);
        return result;
    }
    public void solve(int[]nums, List<List<Integer>> result, List<Integer> current, int start){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i< nums.length; i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            solve(nums, result, current, start);
            current.remove(current.size()-1);
        }
    }
}
