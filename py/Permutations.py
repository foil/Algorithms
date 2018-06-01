class Solution:
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        Solution.perm_recur(nums, 0, res)
        return res

    @staticmethod
    def perm_recur(nums, start, res):
        if start == len(nums) - 1:
            res.append(nums[:])
        else:
            for i in range(start, len(nums)):
                nums[start], nums[i] = nums[i], nums[start]
                Solution.perm_recur(nums, start + 1, res)
                nums[start], nums[i] = nums[i], nums[start]
