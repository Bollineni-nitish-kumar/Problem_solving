/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        mps(root);
        return maxSum;
    }

    private int mps(TreeNode root){
        if(root == null){
            return -10000;
        }

        int leftMax = mps(root.left);
        int rightMax =mps(root.right);

        int lrr = leftMax+rightMax+root.val;
        int lr = leftMax+root.val;
        int rr = rightMax+root.val;
        int r = root.val;

        maxSum  = Math.max(maxSum,Math.max(lrr,Math.max(lr,Math.max(rr,r))));
        return Math.max(lr,Math.max(rr,r));
    }
}
