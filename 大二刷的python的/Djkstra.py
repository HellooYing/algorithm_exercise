import random
def init(x=4):
    l = [[random.randint(0,55) for i in range(0,x+1)] for i in range(0,x+1)]
    for i in range(0,len(l)):
        l[i][i]=0
    return l
        
#迪杰斯特拉算法是从一个源点开始，以这个源点这行的最小值为确定值，然后去确定值那行依次确定通过确定值走去别的点的距离会不会更近，循环次数是n-2。
def d(matrix=init()):
    print(matrix)
    c=[]
    for i in range(0,len(matrix)):
        for j in range(0,len(matrix)-2):
            c.append((matrix[i][0],0))
            t1=filter(lambda y:(y,matrix[i].index(y)) not in c,matrix[i])
            t2=[]
            for xxx in t1:
                t2.append(xxx)
            if len(t2)==1:
                continue
            cc=min(*t2)
            tt=matrix[i].index(cc)
            c.append((cc,tt))
            for jj in range(0,len(matrix)):
                if matrix[i][tt]+matrix[tt][jj]<matrix[i][jj]:
                    matrix[i][jj]=matrix[i][tt]+matrix[tt][jj]
                else:
                    pass
    print(matrix)

d()