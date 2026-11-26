class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] dpArr : dp){
            Arrays.fill(dpArr,-1);
        }

        for(int i=0;i<coins.length;i++){
            dp[i][0] =0;
        }
        for(int i=1;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int notInclude =dp[i-1][j];

                int include=Integer.MAX_VALUE;
                if(j>=coins[i] && dp[i][j-coins[i]] !=Integer.MAX_VALUE){
                    include = dp[i][j-coins[i]]+1;
                }
                dp[i][j]=Math.min(include,notInclude);
            }
        }

        return (dp[coins.length-1][amount] !=Integer.MAX_VALUE)? dp[coins.length-1][amount]:-1;
        /*int result = coinChange(coins,coins.length-1,amount,dp);
        return (result == Integer.MAX_VALUE) ? -1 : result;
        */
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
