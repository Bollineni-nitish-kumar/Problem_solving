class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length+1];
        dp1[0]=0;
        dp1[1] = Math.max(dp1[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            int include = nums[i]+dp1[i-2];
            int notInclude = 0+dp1[i-1];
            dp1[i] = Math.max(include,notInclude);

            System.out.println(dp1[i]);
        }

        int[] dp2 = new int[nums.length+1];
        dp2[0]=nums[0];
        dp2[1] = Math.max(dp2[0],nums[1]);
        
        for(int i=2;i<nums.length-1;i++){
            int include = nums[i]+dp2[i-2];
            int notInclude = 0+dp2[i-1];
            dp2[i] = Math.max(include,notInclude);
            System.out.println(dp2[i]);
        }

        return Math.max(dp1[nums.length-1],dp2[nums.length-2]);
        
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
