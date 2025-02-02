class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;        
    }
    public void backtrack(int[]nums, int target, List<List<Integer>> result, List<Integer>current, int index){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index>=nums.length){
            return;
        }
        current.add(nums[index]);
        backtrack(nums, target-nums[index], result, current, index);
        current.remove(current.size()-1);
        backtrack(nums, target, result, current, index+1);

    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int[]nums, int t, List<List<Integer>> result, List<Integer>current, int i){
        if( t == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(t<0 || i>=nums.length){
            return;
        }
        for(int k = i; k<nums.length; k++){
            current.add(nums[k]);
            backtrack(nums,t-nums[k],result, current,k);
            current.remove(current.size()-1);
        }
    }
}
