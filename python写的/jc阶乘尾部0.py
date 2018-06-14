
#超时
# class Solution:
#     """
#     @param: n: An integer
#     @return: An integer, denote the number of trailing zeros in n!
#     """

#     def trailingZeros(self, n):
#         # write your code here, try to do it without arithmetic operators.
#         s = 1
#         for i in range(1, n+1):
#             s = s*i
#         l = list(str(s))
#         o = 0
#         j = -1
#         while True:
#             if l[j] == '0':
#                 j = j-1
#                 o = o+1
#             else:
#                 break
#         return o


# a = Solution()
# print(a.trailingZeros(11))


# def jiecheng():
#     m = 1
#     s = 1
#     while True:
#         m = m+1
#         s = m*s
#         yield s
# t1=jiecheng()
# for i in range(1,5):
#     t=next(t1)
#     print(t)

class Solution:
    """
    @param: n: An integer
    @return: An integer, denote the number of trailing zeros in n!
    """
    def trailingZeros(self, n):
        # write your code here, try to do it without arithmetic operators.
        def five():
            m=5
            s=1
            while True:
                s=m*s
                yield s
        t=five()
        l=[]
        while True:
            t1=next(t)
            if t1<n:
                l.append(t1)
            else:
                break
        for i in range(0,len(l)):
            l[i]=int(n/l[i])
        return sum(l)

a = Solution()
print(a.trailingZeros(111111))