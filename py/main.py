from LongestFibSubseq import Solution


def main():
    s = Solution()
    ins = [
        # ([1,2,3,4,5,6,7,8], 5),
        # ([1,3,7,11,12,14,18], 3),
        ([2,4,7,8,9,10,14,15,18,23,32,50], 5)
    ]
    for i in ins:
        r = s.lenLongestFibSubseq(i[0])
        print(r, i[1])

if __name__ == '__main__':
    main()
