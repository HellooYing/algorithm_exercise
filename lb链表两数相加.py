# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        a=l1
        b=l2
        while l1.next!=None and l2.next!=None:
            l1=l1.next
            l2=l2.next
        if l1.next==None:
            while l2.next!=None:
                l2=l2.next
                l1.next=ListNode(0)
                l1=l1.next
                
        else:
            while l1.next!=None:
                l1=l1.next
                l2.next=ListNode(0)
                l2=l2.next
        l1=a
        l2=b
        if l1.val+l2.val>=10:
            f=ListNode(l1.val+l2.val-10)
            a=f
            add=1
            if l1.next==None:
                a.next=ListNode(1)
                a=a.next
                add=0
        else:
            f=ListNode(l1.val+l2.val)
            a=f
            add=0
        while l1.next!=None and l2.next!=None:
            l1=l1.next
            l2=l2.next
            if l1.val+l2.val+add<10:
                a.next=ListNode(l1.val+l2.val+add)
                a=a.next
                add=0
            else:
                a.next=ListNode(l1.val+l2.val+add-10)
                a=a.next
                add=1
        if add==1:
            a.next=ListNode(1)
        return f
#因为链表自己写test有点麻烦就不写能执行的样例了