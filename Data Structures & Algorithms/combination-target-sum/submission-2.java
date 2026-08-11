class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums,0,target,new ArrayList<Integer>(),result);
        return result;
        
    }

    private void backTrack(int[] nums, int start, int remTarget, List<Integer> curr,List<List<Integer>> result){
        if(remTarget == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(nums[i] > remTarget){
                break;
            }

            curr.add(nums[i]);

            backTrack(nums,i,remTarget-nums[i],curr,result);

            curr.remove(curr.size()-1);
        }

    }
}
