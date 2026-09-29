class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        String key = s1 + "#" + s2;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int n = s1.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int x : freq) {
            if (x != 0) {
                dp.put(key, false);
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                dp.put(key, true);
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}