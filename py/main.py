from SortedArrToBST import Solution


def main():
    # nums = [2, 3, 4, 5, 6]
    nums = [0]
    s = Solution()
    tn = s.sortedArrayToBST(nums)
    print tn

if __name__ == '__main__':
    main()
