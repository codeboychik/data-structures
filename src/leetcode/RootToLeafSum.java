package leetcode;

import java.util.AbstractMap;
import java.util.Stack;

/**
 *
 * File is created by andreychernenko at 31.10.2025
 *
 *
 */


public class RootToLeafSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int sumNumbersRecursive(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int num) {
        if(root == null) return 0;
        num = num*10 + root.val;
        if (root.right == null && root.left == null) return num;
        return dfs(root.left, num) + dfs(root.right, num);
    }

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        // Each stack item stores: (node, path leading to node)
        record Pair(TreeNode key, int value){}
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.key;
            Integer num = current.value;
            if (node.left == null && node.right == null) {
                System.out.println(num);
                sum += num;
            }
            if (node.right != null) {
                stack.push(new Pair(node.right,  num * 10 + node.right.val));
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, num * 10 + node.left.val));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(7)
                )
            ), new TreeNode(3,
            null,
            new TreeNode(8,
                new TreeNode(9),
                null))
        );
        System.out.println(sumNumbersRecursive(tree));
    }
}
