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

 public class Pair{
    int maxValue=-10000;
    int minValue = 10000;
    boolean isValid;

    public Pair(int maxValue,int minValue, boolean isValid){
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.isValid = isValid;
    }

    public Pair(boolean isValid){
        this.isValid=isValid;
    }
 }

class Solution {
    public boolean isValidBST(TreeNode root) {
        Pair p = isValid(root);
        return p.isValid;

        
    }

    public Pair isValid(TreeNode root){
        if(root == null){
            return new Pair(true);
        }

        Pair left = isValid(root.left);
        Pair right = isValid(root.right);
        if(!left.isValid  || !right.isValid || left.maxValue >= root.val || right.minValue <= root.val){
            return new Pair(false);
        }

        int leftMax = Math.max(root.val,Math.max(left.maxValue,right.maxValue));
        int rightMin = Math.min(root.val,Math.min(left.minValue,right.minValue));

        return new Pair(leftMax,rightMin,true);



    }
}
