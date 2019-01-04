from ReverseLinkedListII import Solution
from ListNode import ListNode


def main():
    s = Solution()
    tests = [
                ([1,2,3,4,5], (1, 2), [2,1,3,4,5]),
                ([1,2,3,4,5], (1, 1), [1,2,3,4,5]),
                ([1,2,3,4,5], (1, 5), [1,2,3,4,5]),
                ([1,2,3,4,5], (2, 2), [1,2,3,4,5])
            ]
    for ori, between, expect in tests:
        A = ListNode.fromArray(ori)
        h = s.reverseBetween(A, between[0], between[1])
        print 'between %d, %d:' % between
        print 'expect: %s, got: %s\n' % (expect, str(h))

if __name__ == '__main__':
    main()
