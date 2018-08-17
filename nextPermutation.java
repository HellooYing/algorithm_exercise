public class nextPermutation {
    public static void main(String[] args) throws Exception {
        int[] a = { 3,2,4 };
        new nextPermutation().answer(a);
        for(int aa:a)
            System.out.println(aa);
    }

    public void answer(int[] nums) {
        //下一个排列
        //以三为例,012->021->102->120->201->210->012
        //小中大->小大中->中小大->中大小->大小中->大中小->小中大
        //其中有两种变化方式,一种是list[-1]>list[-2],只要把list[-1]和list[-2]交换就好;
        //分析到这里绝对以三为例分析不出list[-1]和list[1],改以五为例
        //01234->01243->01324->01342->01423->01432->02134->02143->02314->02341->02413->02431->03124
        //可见是,在长度为n的数组中找到第一个list[i]>list[i-1]的,这次要操作的就是i-1到n-1的元素,共n-i+1个
        //对这n-i+1个元素的处理是把比list[i-1]大的数中最小的与list[i-1]交换,然后对list[i]到list[n-1]从小到大排序.
        //i的改变方法是从i=n-1开始i--,如果list[i]>list[i-1]就break
        //这个方案对没有下一个更大排列的数组无效,所以对这种情况单独处理,直接反转
        int n=nums.length;
        int i;
        int tmp;
        for(i=n-1;i>=0;i--){
            //从尾开始,如果list[i]>list[i-1]就break,得到i.如果是递减数列,i==0直接break,不会list[i-1]
            if(i==0) break;
            else if(list[i]>list[i-1]) break;
        }
        if(i==0){
            for(int j=0;j<n/2;j++){
                tmp=list[j];
                list[j]=list[n-1-j];
                list[n-1-j]=tmp;
            }
        }
        else{
            int minlarge=Integer.MAX_VALUE;//比list[i-1]大的最小的数
            int minlarge_i;//数的序号
            for(int j=i;j<n;j++){
                if(list[j]<list[i-1]) continue;
                else if(list[j]<minlarge){
                    minlarge=list[j];
                    minlarge_i=j;
                }
            }
            tmp=list[i-1];
            list[i-1]=list[minlarge_i];
            list[minlarge_i]=tmp;
            Arrays.sort(list, i, n);
        }
    }
}
