
# 快速排序，就是选定第一个数为基数，从倒数第一个数和第一个数开始往中间走，倒数第一个数（右数）先走，
# 走到小于基数的数时停，左数再走，走到大于基数的数时停，交换这两个数，右数继续往左边走，如果右数走到了左数身上，
# 就把这个数与基数交换，然后把左数右数的左边和右边分别作为一个列表递归调用本函数。
# 为了给递归一个返回条件，定义当左数下标大于右数下标时，返回。
# 刚开始想直接传list，发现不太好，还是传数字吧

#!!!跑lintcode容易级排序超时，吓得我反手就是一个sorted
#sorted不行，虽然print一下出来的数组是排好序的原数组并且return的也是排好序的原数组，但输出却是没有排序的，有点惊奇
import random
def kp(list1,l='1',r='1'):
    if l=='1':
        l=0
    if r=='1':
        r=len(list1)-1
    cl=l
    cr=r
    if l>=r:
        return
    base=list1[l]
    while True:
        while list1[r]>=base and r>l:
            r=r-1
        while list1[l]<=base and r>l:
            l=l+1
        if(r>l):
            t=list1[r]
            list1[r]=list1[l]
            list1[l]=t
        else:
            break
        
    t=list1[r]
    list1[r]=list1[cl]
    list1[cl]=t
    kp(list1,cl,r)
    kp(list1,r+1,cr)
    return list1

l=[random.randint(-100,100) for i in range(0,random.randint(5,30))]
print("原列表：",l)
print("排序后：",kp(l))