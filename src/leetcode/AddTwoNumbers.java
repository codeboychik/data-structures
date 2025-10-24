package leetcode;

/**
 *
 * File is created by andreychernenko at 23.10.2025
 *
 *
 */

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString(){
            return "val: " + val;
        }

    }

    /*
    * pitfall strategy is to:
    *   choose converting ListNode to int
    *   sum them as ints
    *   convert to listNode back
    * Working trategy is to sum them as Nodes, node by node.
    *
    * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode prev = null;
        boolean carry = false; // 7 + 7 = 4 + 1 to the next digit
        while (l1 != null || l2 != null || carry) {
            if (l1 == null) {
                // if l1 is shorter, create a new node to continue
                l1 = new ListNode(0);
                prev.next = l1;
            }

            int sum = l1.val + (l2 == null ? 0 : l2.val) + (carry ? 1 : 0);
            l1.val = sum % 10;
            carry = sum >= 10;

            prev = l1;
            l1 = l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))));
        //ListNode l1 = new ListNode(0, null);
        //ListNode l2 = new ListNode(7, new ListNode(3));
        addTwoNumbers(l1, l2);
    }
}
