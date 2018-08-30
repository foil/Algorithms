
class Solution:
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        queue = [[root], []]
        l = 0
        r = 1
        while queue[l]:
            bl = queue[l][0]
            for t in queue[l]:
                if t.left:
                    queue[r].append(t.left)
                if t.right:
                    queue[r].append(t.right)
            queue[l] = []
            l, r = r, l

        return bl.val


from TreeNode import TreeNode
def main():
    s = Solution()
    t = TreeNode(1)
    print(s.findBottomLeftValue(t))
    t.left = TreeNode(2)
    t.right = TreeNode(3)
    print(s.findBottomLeftValue(t))
    t.left.left = TreeNode(4)
    t.right.left = TreeNode(5)
    print(s.findBottomLeftValue(t))
    t.right.right = TreeNode(6)
    t.right.left.left = TreeNode(7)
    print(s.findBottomLeftValue(t))

if __name__ == '__main__':
    main()