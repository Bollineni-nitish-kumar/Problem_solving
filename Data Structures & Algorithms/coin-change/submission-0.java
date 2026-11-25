class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = coinChange(coins,coins.length-1,amount,0);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private int coinChange(int[] coins ,int index,int remainingAmount,int tc){
         if(index <0 || remainingAmount <0){
            return Integer.MAX_VALUE;
         }
         if(remainingAmount == 0){
            return tc;
         }

         int include = coinChange(coins,index,remainingAmount-coins[index],tc+1);

         int notInclude = coinChange(coins,index-1,remainingAmount,tc);

         return Math.min(include,notInclude);
    }
}
