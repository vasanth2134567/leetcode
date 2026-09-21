// Last updated: 9/21/2026, 9:26:15 PM
1class Solution {
2    public void deleteNode(ListNode node) {
3
4        node.val = node.next.val;
5        node.next = node.next.next;
6    }
7}