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
    private Map<Integer,Integer> ins = new HashMap<>();
    private int preIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            ins.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1);

    }

    private TreeNode build(int[] preorder, int inStart,int inEnd){
        if(inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndx++]);

        int inIdx = ins.get(root.val);

        root.left = build(preorder,inStart,inIdx-1);
        root.right = build(preorder,inIdx+1,inEnd);

        return root;
    }
}
