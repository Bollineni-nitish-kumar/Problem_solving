class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSB = new StringBuilder();
        StringBuilder subRootSB = new StringBuilder();

        preOrderTraverse(root, rootSB);
        preOrderTraverse(subRoot, subRootSB);

        return rootSB.toString().contains(subRootSB.toString());
    }

    private void preOrderTraverse(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",#"); 
            return;
        }

        sb.append(",").append(node.val); 
        preOrderTraverse(node.left, sb);
        preOrderTraverse(node.right, sb);
    }
}