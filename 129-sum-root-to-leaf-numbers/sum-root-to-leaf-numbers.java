class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        // Calculate the value represented by the path to this node
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the path sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively sum up paths from left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
