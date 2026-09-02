class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        if(nums.length <= 1){
            return nums[0];
        }

        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],dp[0]);

        for(int i=2;i<nums.length;i++){
           int include = nums[i]+dp[i-2];
           int notInclude = 0+dp[i-1];
           dp[i] = Math.max(include,notInclude);
        }
        return dp[nums.length-1];
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
