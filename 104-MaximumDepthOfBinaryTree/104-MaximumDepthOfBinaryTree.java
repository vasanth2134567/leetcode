// Last updated: 7/17/2026, 2:57:44 PM
class Solution {
    public int maxDepth(TreeNode root) {
        // base case
        if(root == null)return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}