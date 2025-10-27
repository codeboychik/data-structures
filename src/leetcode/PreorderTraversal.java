package leetcode;

import java.util.*;

/**
 *
 * File is created by andreychernenko at 27.10.2025
 *
 *
 */


public class PreorderTraversal {
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

    public static List<Integer> preorderTraversalBreadthFirst(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return List.of();
        q.add(root);
        while(!q.isEmpty()) {
            root = q.poll();
            result.add(root.val);
            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
        }
        return result;
    }

    public static List<Integer> preorderTraversalDepthFirst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return List.of();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) stack.add(root.right);
            if (root.left != null) stack.add(root.left);
        }
        return result;
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
        // [1,2,4,5,6,7,3,8,9]
        System.out.println(preorderTraversalDepthFirst(tree));
    }
}
