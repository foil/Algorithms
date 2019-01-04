class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @staticmethod
    def fromArray(arr):
        dummy = ListNode(-1)
        p = dummy
        for n in arr:
            p.next = ListNode(n)
            p = p.next

        return dummy.next

    def __str__(self):
        res = '[' + str(self.val)
        p = self.next
        while p:
            res += ', ' + str(p.val)
            p = p.next

        return res + ']'
