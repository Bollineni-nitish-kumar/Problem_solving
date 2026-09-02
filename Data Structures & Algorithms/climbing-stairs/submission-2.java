class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return  climbDP(n,dp);

    }

    public int climbDP(int n , int[] dp){
        if(n == 0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n] !=-1){
            return dp[n];
        }
        int oneStep = climbDP(n-1,dp);
        int twoSteps = climbDP(n-2,dp);
        dp[n] = oneStep+twoSteps;
        return dp[n];
    }
}
