class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l=list(s)
        print(l)
        b1=[]
        b2=[]
        b2_head=0
        i=0
        while i <len(l)-1:
            if l[i] not in b2:
                b2.append(l[i])
            else:
                if len(b1)>=len(b2):
                    print(l[b2_head:b2_head+len(b2)])
                    print("b2:",b2)
                    if i>=len(l)-1:
                        break
                    i=l[b2_head:b2_head+len(b2)].index(l[i])
                    b2_head=i+1
                    b2=[]
                    
                else:
                    b1=b2[:]
                    print("下面",l[b2_head:b2_head+len(b2)])
                    print("b2:",b2)
                    if i>=len(l)-1:
                        break
                    i=l[b2_head:b2_head+len(b2)].index(l[i])
                    b2_head=i+1
                    b2=[]
            i=i+1
                    
        return len(b1)

a=Solution()
print(a.lengthOfLongestSubstring("abcabcbb"))