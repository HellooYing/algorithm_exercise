#先表示出奇数的无穷序列，
#再写一个返回判断此数是否为n的倍数的函数的函数，
#再在无穷奇数序列中调用判断函数，再输出1000以内的素数
def odd_generator():
    n=1
    while True:
        n=n+2
        yield n


def su_generator():
    yield 2
    it=odd_generator()
    while True:
        n=next(it)
        yield n
        it=filter(lambda x:x%n!=0,it)

for i in su_generator():
    if i<1000:
        print(i)
    else:
        break

