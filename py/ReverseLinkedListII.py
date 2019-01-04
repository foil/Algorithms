from ListNode import ListNode

class Solution:
    def reverseBetween(self, head, m, n):
        start = m
        k = n - m
        if m == 1:
            dummy = ListNode(0)
            dummy.next = head
        else:
            dummy = head
            while m > 2:
                dummy = dummy.next
                m -= 1

        h = dummy.next
        m = h.next
        while k > 0:
            t = m.next
            m.next = h
            h = m
            m = t
            k -= 1

        dummy.next.next = m
        dummy.next = h
        
        return dummy.next if start == 1 else head

    def rec_reverse(self, head):
        if not head.next:
            return head, head

        h, t = self.rec_reverse(head.next) 
        t.next = head
        head.next = None
        return h, head

    def iter_reverse(self, head):
        h = head
        m = head.next
        while m:
            t = m.next
            m.next = h
            h = m
            m = t

        head.next = None
        return h
