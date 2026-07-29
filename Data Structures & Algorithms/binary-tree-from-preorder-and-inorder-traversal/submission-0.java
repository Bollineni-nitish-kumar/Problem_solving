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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBT(0,preorder.length-1,0,preorder.length-1,preorder,inorder);
    }

    private TreeNode buildBT(int preStart,int preEnd,int inStart,int inEnd,int[] preOrder,int[] inOrder){
        if(preStart == preEnd){
            return new TreeNode(preOrder[preStart]);
        }
        if(preStart <0 || preEnd >=preOrder.length || inStart < 0 || inEnd >=preOrder.length){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        
        int rootIndx = -1;
        for(int i= inStart ; i<=inEnd;i++){
           if(inOrder[i] == root.val){
              rootIndx = i;
              break;
           }
        }

        int leftNodes = rootIndx - inStart;
        int rightNodes = inEnd-rootIndx;
        if(leftNodes > 0){
            root.left = buildBT(preStart+1,preStart+leftNodes,rootIndx-leftNodes,rootIndx-1,preOrder,inOrder);
        }
        if(rightNodes > 0){
            root.right = buildBT(preStart+1+leftNodes,preEnd,rootIndx+1,rootIndx+rightNodes,preOrder,inOrder);
        }

        return root;

    }
}
