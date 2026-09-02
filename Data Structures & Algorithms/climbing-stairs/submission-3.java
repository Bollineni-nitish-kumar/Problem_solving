class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return  dp[n];

    }

    public int climbDP(int n , int[] dp){
        if(n <= 1){
            return 1;
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
