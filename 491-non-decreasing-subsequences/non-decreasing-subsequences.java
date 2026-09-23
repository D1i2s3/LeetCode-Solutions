class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }

        boolean[] used = new boolean[201];

        for (int i = start; i < nums.length; i++) {

            // Must be non-decreasing
            if (!current.isEmpty() && nums[i] < current.get(current.size() - 1)) {
                continue;
            }

            // Avoid duplicate choices at the same recursion level
            if (used[nums[i] + 100]) {
                continue;
            }

            used[nums[i] + 100] = true;

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}