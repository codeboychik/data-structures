package data.structures;

public class ArrayList {

    public static int sumRecursive(Node node, int sum) {
        if (node == null) {
            return sum;
        }
        sum += node.value;
        return sumRecursive(node.next, sum);
    }
    public static int sumNonRecursive(Node node) {
        int sum = 0;
        if (node == null) {
            return sum;
        }
        while(node != null) {
           sum += node.value;
           node = node.next;
        }
        return sum;
    }

    public static boolean pushRecursive(Node node, Node toInsert) {
        if(node == null) {
            node = toInsert;
            return true;
        }
        if(node.next == null) {
            node.next = toInsert;
            return true;
        }
        return pushRecursive(node.next, toInsert);
    }
    public static Node pushNonRecursive(Node node, Node toInsert) {
        if(node == null) {
            return toInsert;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = toInsert;
        return node;
    }

    public static int sizeRecursive(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.next);
    }
    public static int sizeNonRecursive(Node node) {
        if(node == null) {
            return 0;
        }
        int size = 1;
        do {
            size+=1;
            node = node.next;
        } while(node.next != null);
        return size;
    }

    public static Node removeFirst(Node node) {
        if(node == null) {
            throw new IllegalStateException("Cannot remove first element of null");
        }
        node = node.next;
        return node;
    }
    public static Node removeLastRecursive(Node node) {
        if(node == null) throw new IndexOutOfBoundsException("node is null");
        if(node.next == null) return null;
        node.next = removeLastRecursive(node.next);
        return node;
    }
    public static Node removeAtRecursive(Node node, int index) {
        if(index < 0) throw new IndexOutOfBoundsException("negative index");
        if(node == null) throw new IndexOutOfBoundsException("node is null");
        if(index == 0) return node.next;
        node.next = removeAtRecursive(node.next, index - 1);
        return node;
    }

    public static void printReversed(Node node) {
        if(node.next != null) {
            printReversed(node.next);
        }
        System.out.println(node.value);
    }
    public static void printNormal(Node node) {
        if(node.next == null) {
            System.out.println(node.value);
            return;
        }
        System.out.println(node.value);
        printNormal(node.next);
    }

    public static void main(String[] args) {
        Node list = new Node(1, new Node(2, new Node(3, null)));
        pushNonRecursive(list, new Node(4, null));
        printNormal(list);
        System.out.println("--------");
        System.out.println(sizeRecursive(list));
    }


}
