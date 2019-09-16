import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class yfd2019091602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s=sc.nextInt();
        int[] c=new int[n];
        for(int i = 0; i < n; i++){
            c[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(answer(c,s));
    }
    public static int answer(int[] c,int s){
        if(c.length==0) return 0;
        //dp[i]:以s的第i位结尾对应的最长连续不触发位数
        //v[i]:dp[i]对应的分数
        //加上当前位不触发的话，就直接是加上的值
        //加上了触发的话，就是减掉前面的多少位不触发为止
        //本身就大过s的话就直接为0
        int[] dp=new int[c.length];
        int[] v=new int[c.length];
        if(c[0]>s){
            dp[0]=0;
            v[0]=0;
        }
        else {
            dp[0]=1;
            v[0]=c[0];
        }
        for (int i = 1; i <c.length ; i++) {
            if(c[i]>s){
                dp[i]=0;
                v[i]=0;
            }
            //如果以上一位结尾的最长序列加上当前课的分数不超s
            else if(v[i-1]+c[i]<s){
                dp[i]=dp[i-1]+1;
                v[i]=v[i-1]+c[i];
            }
            //正常情况 要舍弃一部分前面的数
            else{
                dp[i]=dp[i-1]+1;
                v[i]=v[i-1]+c[i];
                while(v[i]>s){
                    //舍弃最前面那位
                    dp[i]--;
                    v[i]-=v[i-dp[i]];
                }
            }
        }
        int max=0;
        for (int i = 0; i <dp.length ; i++) {
            if(max<dp[i]) max=dp[i];
        }
        return max;
    }
}
