/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode currenteven = head.next;
        ListNode currentodd = head;
        ListNode even = head.next;
        while(currenteven!=null && currenteven.next!=null){
            currentodd.next = currenteven.next;
            currentodd = currenteven.next;

            currenteven.next = currentodd.next;
            currenteven = currentodd.next;
        }
        currentodd.next = even;
        return head;
    }
}
