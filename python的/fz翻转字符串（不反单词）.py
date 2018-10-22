class Solution:
    """
    @param: s: A string
    @return: A string
    """
    def reverseWords(self, s):
        # write your code here
        l=s.split()
        l.reverse()
        ll=''
        for i in l:
            ll=ll+str(i)+' '
        return ll
a=Solution()
print(a.reverseWords('self s kk'))