class Solution:
    def findGCD(self, nums: List[int]) -> int:
        min = nums[0]
        max = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > max:
                max = nums[i]
            if nums[i] < min:
                min = nums[i]
    
    # Euclidean algorithm to find GCD
        while min != 0:
            temp = min
            min = max % min
            max = temp
        return max