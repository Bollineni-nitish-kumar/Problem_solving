class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robdp(nums,nums.length-1,dp);
    }

    public int robdp(int[] nums,int n,int[] dp){
        if(n<0){
            return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }

        int include = nums[n]+robdp(nums,n-2,dp);
        int notInclude = 0+robdp(nums,n-1,dp);

        return dp[n]=Math.max(include,notInclude);
    }
}
