class Solution:
    def getRow(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows==0:
            return [1]
        a=[[1]]
        def create(raw,a):
            l=[]
            l.append(1)
            for i in range(1,raw-1):
                l.append(a[-1][i-1]+a[-1][i])
            l.append(1)
            a.append(l)
            return a
        
        for i in range(2,numRows+2):
            a=create(i,a)
        return a[-1]

a=Solution()
print(a.getRow(10))