#归并排序 是把列表先分成1个1个一组，按顺序合并成2个2个一组，再继续合并直到合并完。
def cp(l,f,e,i):
    for j in range(f,e):
        if i>=l[e-1]:
            l.insert(e,i)
            return
        if i>=l[j]:
            j=j+1
        else:
            l.insert(j,i)
            e=e+1
            return
        
def merge(l,f1,e1,f2,e2):#这里e1应该等于f2，而e2可能是不在列表内，操作时应为e-1
    for i in range(f2,e2):
        t=l[i]
        del l[i]
        cp(l,f1,e1,t)
        e1=e1+1
    return

def gb(l):#归并函数不递归
    f=0
    e=len(l)
    n=e-f
    #找到每组的头，如第一组0-1，第二组2-3，第三组4，（如果n为奇数则最后一组头尾相等. i in range（f，e，b）能表示每组的头，
    #第二次是0-3 4 所以b=2*b
    #直到n/b<=2,即只剩两组时，最后一次合并
    b=1
    while n/b>2:
        for i in range(f,e,2*b):
            if i+2*b>len(l):
                continue
            merge(l,i,i+b,i+b,i+2*b)
        b=2*b
    merge(l,f,f+b,f+b,e)
    return l

import random
l=[random.randint(-100,100) for i in range(0,random.randint(5,20))]
cl=l[:]
print("原列表：",cl) 
print("排序后：",gb(l))