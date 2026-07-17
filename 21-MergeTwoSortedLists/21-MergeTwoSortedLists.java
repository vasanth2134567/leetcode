// Last updated: 7/17/2026, 2:58:31 PM
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode link = new ListNode();
        ListNode cur = link;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return link.next;        
    }
}