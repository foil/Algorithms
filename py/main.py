from AddTwoNumbers import Solution, ListNode


def main():
    l1 = ListNode(1)
    l2 = ListNode(9)
    l2.next = ListNode(9)
    s = Solution()
    print(s.addTwoNumbers(l1, l2))


if __name__ == '__main__':
    main()
