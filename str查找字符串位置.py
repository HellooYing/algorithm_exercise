class Solution:
    """
    @param: source: source string to be scanned.
    @param: target: target string containing the sequence of characters to match
    @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
    """
    def strStr(self, source, target):
        # 都变成list 然后从list1中找list2[0]，找到再对比list2[1] 对比完就是它了
        if source is None or target is None:
            return -1
        if target=='':
            return 0
        l1=list(source)
        l2=list(target)
        for i in range(0,len(l1)):
            if l2[0]!=l1[i]:
                continue
            else:
                for j in range(0,len(l2)):
                    l1.extend(l1)#防止l1[i+j]越界
                    if l2[j]!=l1[i+j]:
                        break
                    elif j==len(l2)-1:
                        return i
                    else:
                        continue
        return -1

a=Solution()
print(a.strStr(*["tartarget", "target"]))
