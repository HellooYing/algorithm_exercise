/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(cutRope(2));
    }
    public static int cutRope(int n) {
        /**
         * 题目
         * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
         * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
         * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
         *
         * 解法
         * 感觉不算经典动态规划，只是记忆化而已，反而更像二分。
         * 切成m段，肯定是m段尽量等长时最大，所以封装一个输入长度为n、切成m段，输出乘积
         * 然后肯定是只能剪成1段（不剪）到剪成n段，结束条件是剪成m段时比剪成m-1段和m+1段都大
         * 二分的划分条件是：当剪成m+1段>m段，就说明应该剪成更多段。剪成m-1段>m段，就说明应该剪成更少段。
         * 然后过程中用一个长度为n的数组记录切成m段时的乘积备用
         */
        if(n==1) return n;
        return dichotomy(n,new int[n+1],0,n);
    }

    private static int dichotomy(int n,int[] products,int left,int right){
        if(left>=right){
            return getProduct(n,left);
        }
        int mid=(left+right)/2;
        int p1=0,p=0,p2=0;
        if(mid>1){
            p1=products[mid-1];
            if(p1==0){
                p1=getProduct(n,mid-1);
                products[mid-1]=p1;
            }
        }
        p=products[mid];
        if(p==0){
            p=getProduct(n,mid);
            products[mid]=p;
        }
        p2=products[mid+1];
        if(p2==0){
            p2=getProduct(n,mid+1);
            products[mid]=p2;
        }
        if(p>=p1&&p>=p2){
            if(mid==1) return p2;
            return p;
        }
        else if(p<p1){
            return dichotomy(n,products,left,mid-1);
        }
        else return dichotomy(n,products,mid+1,right);
    }

    private static int getProduct(int n,int m){
        int base=n/m;
        int add=n%m;
        int r=1;
        for (int i = 0; i <m ; i++) {
            if(i<add){
                r=r*(base+1);
            }
            else r=r*base;
        }
        return r;
    }
}
