from AdvantageShuffle import Solution

def main():
    s = Solution()
    inp = [([2,7,11,15], [1,10,4,11], [2,11,7,15]),
           ([12,24,8,32], [13,25,32,11], [24,32,8,12])]
    for p in inp:
        r = s.advantageCount(p[0], p[1])
        print(p[2], r)

if __name__ == '__main__':
    main()
