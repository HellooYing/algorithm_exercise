from bs4 import BeautifulSoup
from urllib.request import urlopen
html = urlopen("http://kaijiang.zhcw.com/zhcw/html/ssq/list_1.html").read().decode('utf-8')
soup = BeautifulSoup(html, features='lxml')
number = soup.find_all('em')
l=[]
for m in number:
   l.append(int(m.get_text()))
html = urlopen("http://kaijiang.zhcw.com/zhcw/html/ssq/list_2.html").read().decode('utf-8')
soup = BeautifulSoup(html, features='lxml')
number = soup.find_all('em')
for m in number:
   l.append(int(m.get_text()))
html = urlopen("http://kaijiang.zhcw.com/zhcw/html/ssq/list_3.html").read().decode('utf-8')
soup = BeautifulSoup(html, features='lxml')
number = soup.find_all('em')
for m in number:
   l.append(int(m.get_text()))
q=len(l)
qq=[]
for i in range(0,q,7):
    qq.append(l[i:i+7])
l.sort()
n=1
d={}
for i in range(1,len(l)):
    if l[i]==l[i-1]:
        n=n+1
    else:
        d[l[i-1]]=n
        n=1
print(d)
qqq=sorted(d.items(), key=lambda d:d[1],reverse=True)
with open('./ssq.txt', 'w') as f:
    for i in qq:
        for j in i:
            f.write(str(j))
            f.write(" ")
        f.write('\n')
    f.close()
with open('./result.txt', 'w') as f:
    for i in qqq:
        f.write("数字"+str(i[0])+"出现次数为："+str(i[1]))
        f.write('\n')
