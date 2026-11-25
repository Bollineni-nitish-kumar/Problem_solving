class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] dpArr : dp){
            Arrays.fill(dpArr,-1);
        }
        int result = coinChange(coins,coins.length-1,amount,dp);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private int coinChange(int[] coins ,int index,int remainingAmount,int[][] dp){
         if(index <0 || remainingAmount <0){
            return Integer.MAX_VALUE;
         }
         if(remainingAmount == 0){
            return 0;
         }
         if(dp[index][remainingAmount]!=-1){
            return dp[index][remainingAmount];
         }

         int include = coinChange(coins,index,remainingAmount-coins[index],dp);
         if(include != Integer.MAX_VALUE){
             include = include+1;
         }
         int notInclude = coinChange(coins,index-1,remainingAmount,dp);

         return dp[index][remainingAmount] = Math.min(include,notInclude);
    }
}
