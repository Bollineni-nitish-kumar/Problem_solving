class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSB = new StringBuilder();
        StringBuilder subRootSB = new StringBuilder();

        serialize(root, rootSB);
        serialize(subRoot, subRootSB);

        return rootSB.toString().contains(subRootSB.toString());
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",#"); // Must mark null pointers explicitly!
            return;
        }

        sb.append(",").append(node.val); // Delimiter protects numbers like 12 vs 1
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}