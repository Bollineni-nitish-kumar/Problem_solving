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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> pAncestors = getAncestors(root,p);
        List<Integer> qAncestors = getAncestors(root,q);

        if(pAncestors.contains(q.val)){
            return q;
        }
        if(qAncestors.contains(p.val)){
            return p;
        }

        for(int ind = pAncestors.size()-1;ind >=0;ind--){
            if(qAncestors.contains(pAncestors.get(ind))){
                return new TreeNode(pAncestors.get(ind));
            }
        }
        return null;
        
    }

    public List<Integer> getAncestors(TreeNode root,TreeNode target){
        List<Integer> ancestors = new ArrayList<>();
        if(root == null){
            return ancestors;
        }

        TreeNode curr = root;

        while(curr != null && curr.val !=target.val){
            ancestors.add(curr.val);

            if(curr.val < target.val){
                curr=curr.right;
            }else{
                curr =curr.left;
            }
        }

        return ancestors;
    }
}
