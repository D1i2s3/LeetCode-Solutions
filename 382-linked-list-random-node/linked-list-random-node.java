class Solution {
    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    public int getRandom() {
        ListNode curr = head;
        int count = 1;
        int ans = 0;
        while (curr != null) {
            if (random.nextInt(count) == 0) {
                ans = curr.val;
            }
            count++;
            curr = curr.next;
        }
        return ans;
    }
}
