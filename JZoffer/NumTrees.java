/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(1));
    }
    public int numTrees(int n) {
        int[] a=new int[n+1];
        a[0]=1;
        a[1]=1;
        if(n<2) return a[n];
        a[2]=2;
        for (int i = 3; i <n+1 ; i++) {
            for (int j = 0; j <i ; j++) {
                a[i]+=a[j]*a[i-j-1];
            }
        }
        return a[n];
    }
}
