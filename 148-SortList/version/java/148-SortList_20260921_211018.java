// Last updated: 9/21/2026, 9:10:18 PM
1public class Solution {
2  
3  public ListNode sortList(ListNode head) {
4    if (head == null || head.next == null)
5      return head;
6        
7    // step 1. cut the list to two halves
8    ListNode prev = null, slow = head, fast = head;
9    
10    while (fast != null && fast.next != null) {
11      prev = slow;
12      slow = slow.next;
13      fast = fast.next.next;
14    }
15    
16    prev.next = null;
17    
18    // step 2. sort each half
19    ListNode l1 = sortList(head);
20    ListNode l2 = sortList(slow);
21    
22    // step 3. merge l1 and l2
23    return merge(l1, l2);
24  }
25  
26  ListNode merge(ListNode l1, ListNode l2) {
27    ListNode l = new ListNode(0), p = l;
28    
29    while (l1 != null && l2 != null) {
30      if (l1.val < l2.val) {
31        p.next = l1;
32        l1 = l1.next;
33      } else {
34        p.next = l2;
35        l2 = l2.next;
36      }
37      p = p.next;
38    }
39    
40    if (l1 != null)
41      p.next = l1;
42    
43    if (l2 != null)
44      p.next = l2;
45    
46    return l.next;
47  }
48
49}