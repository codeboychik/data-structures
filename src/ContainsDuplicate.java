public class ContainsDuplicate {
    public static Integer getNumber(ListNode node, Integer iteration) {
        if(node.next == null) {
            return node.val * iteration;
        }
        return node.val * iteration + getNumber(node.next, iteration * 10);
    }

    public static ListNode getNode(Integer input) {
        if(input / 10 == 0) {
            return new ListNode(input % 10, null);
        }
        return new ListNode(input % 10, getNode(input / 10));
    }

    public static void printList(ListNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.val);
        printList(node.next);
    }

    public static ListNode add(ListNode l1, ListNode l2, Integer carry) {
        ListNode l3 = l1;
        if(l1.next != null) {
            l3 = add(l1.next, l2, carry);
        }
        l3.val += (l2.val + carry) > 10 ? 0 : l2.val + carry;
        carry = l3.val % 10;
        if(l3.val > 10) {
            l3.val = 0;
            l3.next = new ListNode(carry, null);
            add(l1.next == null ? new ListNode(carry, null): l1.next, l2, carry);
        }
        return l3;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1))))))))));

        ListNode head2 = new ListNode(9);
        ListNode head3 = getNode(getNumber(head, 1) + getNumber(head2, 1));
        printList(head3);
        add(head, head2, 0);
    }
}