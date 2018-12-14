import java.util.*;

public class csp2016092 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int k= sc.nextInt();
        int[] zl=new int[k];
        int i=0;
        while (i<k) {
            zl[i]=sc.nextInt();
            i++;
        }
        sc.close();
        List<int[]> r=new csp2016092().answer(zl);
        for(int[] a:r){
            for(int aa:a) {System.out.print(aa);System.out.print(" ");}
            System.out.println();
        }
    }
    int[] find(int n,int[][] w){
        //对每一排找有没有n连坐为0，有则把他们赋1，然后return它们的编号，没有就继续循环
        int[] r=new int[n];;
        int flag=0;
        int i,j,k;
        for(i=0;i<20;i++){//查看每一排
            for(j=0;j<5-n+1;j++){//对这一排每个可以开始的座位，从开始的座位到开始+n的座位进行检查
                flag=0;
                for(k=0;k<n;k++){//检查开始-开始+n的座位
                    if(w[i][j+k]==1) flag=1;//如果有座位是1，就说明不行
                }
                if(flag==0){//如果flag是0，则说明没有座位是1，则说明已经找到
                    for(k=0;k<n;k++){
                        r[k]=i*5+j+k+1;
                        w[i][j+k]=1;
                    }
                    break;
                }
            }
            if(flag==0) break;
        }
        if(r[0]==0){
            for(i=0;i<n;i++){
                r[i]=find(1,w)[0];
            }
        }
        return r;
    }
    public List<int[]> answer(int[] zl){
        List<int[]> r=new ArrayList<int[]>();
        int[][] w=new int[20][5];
        int[] t;
        for(int i=0;i<zl.length;i++){
            t=find(zl[i],w);//对指令zl[i],在w中找第一个合适的位置。
            r.add(t);
        }
        return r;
    }
}