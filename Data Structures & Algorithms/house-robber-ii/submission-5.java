class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
         int case1 = robTabulation(nums,0,nums.length-2);
         int case2 = robTabulation(nums,1,nums.length-1);

         return Math.max(case1,case2);
        
    }

    private int robTabulation(int[] nums, int start,int end){
        int len = end-start+1;
        if(len ==1){
            return nums[start];
        }
        int[] dp = new int[len];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);

        for(int i=2;i< len;i++){
            int include = nums[start+i]+dp[i-2];
            int notInclude= dp[i-1];
            dp[i] = Math.max(include,notInclude);
        }
        return dp[len-1];
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
