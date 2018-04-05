class Solution:
    """
    @param n: the number of disks
    @return: the order of moves
    """
    def towerOfHanoi(self, n):
        l=[]
        def move(n,a="A",b="B",c="C"):
            if n==1:
                l.append("from "+a+" to "+c)
                return l
            move(n-1,a,c,b)
            move(1,a,b,c)
            move(n-1,b,a,c)
        move(n)
        return l

a=Solution()
print(a.towerOfHanoi(5))