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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ions = new ArrayList<>();
        inOrderTraversal(root,ions);
        return ions.get(k-1);

    }

    private void inOrderTraversal(TreeNode root,List<Integer> ions){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left,ions);
        ions.add(root.val);
        inOrderTraversal(root.right,ions);

        return;

    }
}
