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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return levelOrderTtoS(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return levelOrderStoT(data);
    }


    private String levelOrderTtoS(TreeNode root){
        if(root == null ){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                sb.append("*#");
            }else{
                sb.append(curr.val).append("#");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private TreeNode levelOrderStoT(String s){
        if(s== null){
            return null;
        }

        String[] tv= s.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(tv[0])));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int ind = 1;

        while(!q.isEmpty() && ind < tv.length){
            TreeNode curr = q.poll();

            if(!"*".equals(tv[ind])){
                curr.left = new TreeNode(Integer.parseInt(tv[ind]));
                q.add(curr.left);
            }
            ind++;

            if(ind < tv.length && !"*".equals(tv[ind])){
                curr.right = new TreeNode(Integer.parseInt(tv[ind]));
                q.add(curr.right);
            }
            ind++;
        }

        return root;
    }
}
