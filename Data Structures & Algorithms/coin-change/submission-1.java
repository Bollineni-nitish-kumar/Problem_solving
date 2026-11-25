class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = coinChange(coins,coins.length-1,amount);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private int coinChange(int[] coins ,int index,int remainingAmount){
         if(index <0 || remainingAmount <0){
            return Integer.MAX_VALUE;
         }
         if(remainingAmount == 0){
            return 0;
         }

         int include = coinChange(coins,index,remainingAmount-coins[index]);
         if(include != Integer.MAX_VALUE){
             include = include+1;
         }
         int notInclude = coinChange(coins,index-1,remainingAmount);
         
         if(include==Integer.MAX_VALUE && notInclude == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
         }
         return Math.min(include,notInclude);
    }
}
