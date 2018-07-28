class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        r = root
        res = []
        if not r:
            return res

        visited = {}
        stack = [r]
        while stack:
            if r.left and r.left not in visited:
                stack.append(r.left)
                visited[r.left] = True
                r = r.left
            else:
                r = stack.pop()
                res.append(r.val)
                if r.right:
                    stack.append(r.right)
                    r = r.right

        return res