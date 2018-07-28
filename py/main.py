from InorderIteratively import Solution
from TreeNode import TreeNode


def main():
    s = Solution()

    root = TreeNode(2)
    root.left = TreeNode(3)
    root.left.left = TreeNode(1)
    print(s.inorderTraversal(root))

if __name__ == '__main__':
    main()
