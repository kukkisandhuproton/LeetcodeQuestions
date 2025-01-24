class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        Arrays.sort(candidates);
        backtrack(candidates,target,0, result, new ArrayList<>());
        return result;
    }
    public void backtrack(int[]nums, int target, int index, List<List<Integer>> result, List<Integer> current){

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index>=nums.length){
            return;
        }

         if (target < nums[index]){
            return;
         }

        for(int i = index; i<nums.length; i++){
            if( i>index && nums[i] == nums[i-1]){
                continue;
            }

            current.add(nums[i]);
            backtrack(nums, target-nums[i],i+1,result,current);
            current.remove(current.size()-1);

        }
    }
}
