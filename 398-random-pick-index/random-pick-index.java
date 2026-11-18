import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        
        // Pre-compute and group indices for each number
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        int randomIndex = random.nextInt(indices.size());
        return indices.get(randomIndex);
    }
}