from TreeNode import TreeNode


class Solution(object):
    @staticmethod
    def recur(nums, start, end):
        if start > end:
            return None
        else:
            mid = (start + end) / 2
            tn = TreeNode(nums[mid])
            # print 'index:', mid, ', val:', tn.val
            tn.left = Solution.recur(nums, start, mid - 1)
            tn.right = Solution.recur(nums, mid + 1, end)
            return tn

    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return Solution.recur(nums, 0, len(nums)-1)
