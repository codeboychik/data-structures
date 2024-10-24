public class AddTwoNumbers {
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


    public static void main(String[] args) {
        ListNode head = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1))))))))));

        ListNode head2 = new ListNode(9);
        ListNode head3 = getNode(getNumber(head, 1) + getNumber(head2, 1));
        printList(head3);
    }
}