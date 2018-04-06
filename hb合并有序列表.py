class Solution:
    """
    @param A: sorted integer array A
    @param B: sorted integer array B
    @return: A new sorted integer array
    """
    def mergeSortedArray(self, l1, l2):
        i=0
        j=0
        l3=[]
        while True:
            if i==len(l1)-1 and j==len(l2)-1:
                if l1[i]>l2[j]:
                    l3.append(l2[j])
                    l3.append(l1[i])
                else:
                    l3.append(l1[i])
                    l3.append(l2[j])
                break
            elif l1[i]>l2[j]:
                if j!=len(l2)-1:
                    l3.append(l2[j])
                    j=j+1
                else:
                    l3.append(l2[j])
                    l3.extend(l1[i:])
                    break
            else:
                if i!=len(l1)-1:
                    l3.append(l1[i])
                    i=i+1
                else:
                    l3.append(l1[i])
                    l3.extend(l2[j:])
                    break
        return l3

a = Solution()
import random
l1=[random.randint(-100,100) for i in range(0,random.randint(5,10))]
l2=[random.randint(-100,100) for i in range(0,random.randint(5,10))]
print(l1)
print(l2)
print(a.mergeSortedArray(l1,l2))