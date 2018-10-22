#无法在leetcode通过，能在lintcode上通过
#想在力扣上通过就得：
#return source.find(target)
#就好了
class Solution:
    def strStr(self, source, target):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if source is None or target is None:
            return -1
        if target=='':
            return 0
        l1=list(source)
        l2=list(target)
        l1.extend(range(len(l1)))#防止l1[i+j]越界
        for i in range(0,len(l1)):
            if l2[0]!=l1[i]:
                continue
            else:
                for j in range(0,len(l2)):
                    if l2[j]!=l1[i+j]:
                        break
                    elif j==len(l2)-1:
                        return i
                    else:
                        continue
        return -1

a=Solution()
print(a.strStr(*["tartarget","target"]))