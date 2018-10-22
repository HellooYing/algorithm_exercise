#过了77%的数据然后超时嘤嘤嘤
# class Solution:
#     """
#     @param nums: A list of integers
#     @return: A integer indicate the sum of max subarray
#     """
#     def maxSubArray(self, nums):
#         if len(nums)==1:
#             return nums[0]
#         #1~k位的数组之和保留最大的那一个
#         s=[0 for i in range(len(nums)+1)]
#         s[0]=nums[0]
#         for k in range(1,len(nums)+1):
#             for i in range(0,len(nums)-k):
#                 s[k]=max(s[k],sum(nums[i:i+k+1]))
#         if max(*s)==0:
#             return max(*nums)
#         return max(*s)
            
class Solution:
    """
    @param nums: A list of integers
    @return: A integer indicate the sum of max subarray
    """
    def maxSubArray(self, nums):
        #别人家的算法：从头开始加，如果和小于0就从下个数开始加
        #（因为不带着负数走肯定比带着强）
        if len(nums)==1:
            return nums[0]
        s=0
        l=[]
        for i in range(0,len(nums)):
            s=s+nums[i]
            l.append(s)
            if s<0:
                s=0
            else:
                pass
        m=max(*l)
        if m==0:
            return max(*nums)
        return m
a=Solution()
print(a.maxSubArray([-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000]))