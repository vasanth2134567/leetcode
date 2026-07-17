// Last updated: 7/17/2026, 2:57:35 PM
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode node , int curr){
        if(node == null ){
            return 0;
        }

        curr = curr *10 + node.val;

        if(node.left == null && node.right == null){
            return curr;
        }

        return dfs(node.left,curr) + dfs(node.right,curr);
    }
}