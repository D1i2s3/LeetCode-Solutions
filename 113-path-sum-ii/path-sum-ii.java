class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }    private void dfs(TreeNode root, int target, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);

        path.remove(path.size() - 1);
    }
}