package leetcode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * File is created by andreychernenko at 29.10.2025
 *
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">...</a>
 */


public class BTreeRightSideView {

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

    // breadth traversal
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();       // number of nodes at this level
            TreeNode rightmost = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                rightmost = node;           // last node processed in this level = rightmost
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(rightmost.val);      // only add rightmost of each level
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
        System.out.println(rightSideView(tree)); // result is [1, 3, 8, 5, 9, 7]
    }
}
