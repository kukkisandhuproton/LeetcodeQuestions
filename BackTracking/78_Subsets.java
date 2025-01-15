class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        subset(nums,new ArrayList<>(),0);
        return result;
    }
    public void subset(int[]nums, ArrayList<Integer> temp, int index){
        // base condition
        if(index>=nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        // include the index
        temp.add(nums[index]);
        // move ahead and backtrack it
        subset(nums, temp, index+1);
        // remove the index
        temp.remove(temp.size()-1);
        //move ahead and backtrack it
        subset(nums,temp, index+1);
    }
}
