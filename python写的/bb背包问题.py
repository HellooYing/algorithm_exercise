# import random
# def jewel_create(n):#j[0]=value,j[1]=weight
#    return [[random.randint(1,4),random.randint(1,4)] for i in range(0,n)]
# def init_matrix(x,y):
#    return [[0 for i in range(0,x+1)] for i in range(0,y+1)]
# def bag_problem(weight,matrix=init_matrix(8,4),jewel=jewel_create(4)):
#    for w in range(0,weight+1):
#        for j in range(0,len(jewel)):
#            if jewel[j][1]>w:
#                matrix[j][w]=matrix[j-1][w]
#                continue
#            elif matrix[j-1][w-jewel[j][1]]+jewel[j][0]>matrix[j-1][w]:
#                matrix[j][w]=matrix[j-1][w-jewel[j][1]]+jewel[j][0]
#            else:
#                matrix[j][w]=matrix[j-1][w]
#    print('全部宝石：')
#    for k in jewel:
#        print('价值:',k[0],'重量:',k[1],'性价比：',k[0]/k[1])
#    print('宝石数：',j,'总重量：',w,'总价值：',matrix[j][w])
# bag_problem(8)
import random
def jewel_create(n):#j[0]=value,j[1]=weight
    return [[random.randint(1,11),random.randint(1,11)] for i in range(0,n)]
def init_matrix(x,y):
    return [[0 for i in range(0,x+1)] for i in range(0,y+1)]
def bag_problem(weight,matrix=init_matrix(70,10),jewel=jewel_create(10)):
    for w in range(0,weight+1):
        for j in range(0,len(jewel)):
            if jewel[j][1]>w:
                matrix[j][w]=matrix[j-1][w]
            elif matrix[j-1][w-jewel[j][1]]+jewel[j][0]>matrix[j-1][w]:
                matrix[j][w]=matrix[j-1][w-jewel[j][1]]+jewel[j][0]
            else:
                matrix[j][w]=matrix[j-1][w]
    print('全部宝石：')
    for k in jewel:
        print('价值:',k[0],'重量:',k[1],'性价比：%.1f' % (k[0]/k[1]))
    print('宝石数：',j,'总重量：',w,'总价值：',matrix[j][w])
bag_problem(50,init_matrix(70,10),[[12,5],[30,15],[44,25],[46,27],[50,30]])