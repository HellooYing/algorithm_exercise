import random
def conflict(l):
    row=len(l)-1
    col=l[-1]
    for i in range(len(l)-1):
        r=i
        c=l[i]
        print(r,c,row,col)
        if abs(r-row)==abs(c-col):
            return True
    return False

def main():
    result=[]
    t=[]
    for i1 in range(0,3):
        t.append(i1)
        for i2 in range(0,3):
            t.append(i2)
            if conflict(t):
                t.pop()
                continue
            else:
                for i3 in range(0,3):
                    t.append(i3)
                    print(t)
                    if conflict(t):
                        print("conflict")
                    else:
                        result.append(t[:])
                    t.pop()
            t.pop()
        t.pop()
    return result

print(main())
