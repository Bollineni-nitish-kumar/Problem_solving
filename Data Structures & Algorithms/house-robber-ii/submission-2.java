class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int include = robDp(nums,1,nums.length-1,dp);
        Arrays.fill(dp,-1);
        int notInclude = robDp(nums,0,nums.length-2,dp);

        return Math.max(include,notInclude);
        
    }

    private int robDp(int[] nums,int start, int n,int[] dp){
        if(n < start){
           return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }

        int include = nums[n]+robDp(nums,start,n-2,dp);
        int notInclude = 0+robDp(nums,start,n-1,dp);

        return dp[n]=Math.max(include, notInclude);
    }
}
