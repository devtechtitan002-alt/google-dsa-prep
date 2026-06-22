package Revision.DailyDose;

public class DeletetheMiddleNodeofaLinkedList {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
    public ListNode deleteMiddle(ListNode head) {

        ListNode slow=head,fast=head,prevMiddle=null;

        while(fast!=null && fast.next != null){

            // Node for Previous for Middle Node
            prevMiddle = slow;

            // find middle logic
            slow = slow.next;
            fast = fast.next.next;

        }

        if(prevMiddle == null) return null;

        ListNode nextMiddle = prevMiddle.next == null ? null : prevMiddle.next.next;

        prevMiddle.next = nextMiddle;

        return head;
        
    }
    }
}
