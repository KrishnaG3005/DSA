class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int a:nums)
            pq.add(a);
        int[] ans = new int[nums.length];
        int idx = 0;

        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = pq.poll();
            ans[idx++] = b;
            ans[idx++] = a;
        }

        return ans;

    }
}