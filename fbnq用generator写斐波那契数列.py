def fbnq():
    yield 1
    yield 1
    a=1
    b=1
    while True:
        c=a+b
        yield c
        a=b
        b=c

for i in fbnq():
    if i < 100:
        print(i)
    else:
        break