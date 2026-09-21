// Last updated: 9/21/2026, 8:55:51 PM
1class Solution {
2    public Node connect(Node root) {
3        if(root == null) return null;
4        if(root.left != null) root.left.next = root.right;
5        if(root.right != null && root.next != null) root.right.next = root.next.left;
6        connect(root.left);
7        connect(root.right);
8        return root;
9    }
10}