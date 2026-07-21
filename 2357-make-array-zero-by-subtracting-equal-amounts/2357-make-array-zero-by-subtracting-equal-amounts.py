class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        heapq.heapify(nums)
        rounds = 0
        while nums:
            while nums and nums[0] == 0:
                heapq.heappop(nums)
            if nums:
                k = heapq.heappop(nums)
                rounds += 1
                for i in range(len(nums)):
                    nums[i] -= k
        return rounds