from RobotSim import Solution


def main():
    s = Solution()
    ins = [
        ([4,-1,4,-2,4], [[2,4]], 65),
        ([4,-1,3], [], 25),
        ([-2,-1,8,9,6], [[-1,3],[0,1],[-1,5],[-2,-4],[5,4],[-2,-3],[5,-1],[1,-1],[5,5],[5,2]], 0),
    ]
    for i in ins:
        r = s.robotSim(i[0], i[1])
        print(r, i[2])

if __name__ == '__main__':
    main()
