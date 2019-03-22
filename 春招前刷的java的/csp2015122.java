import java.util.*;

public class csp2015122 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] qipan=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                qipan[i][j]=sc.nextInt();
            }
        }
        sc.close();
        new csp2015122().answer(qipan);
        for(int[] a:qipan){
            for(int aa:a){
                System.out.print(aa);System.out.print(" ");
            }
            System.out.println();
        }
    }

    int findBottom(int i,int j,int[][] qipan){
        int n=qipan.length;
        if(i==n-1||qipan[i][j]==0) return 0;
        int r=0;
        for(int ii=i+1;ii<n;ii++){
            if(qipan[ii][j]==qipan[i][j]) r++;
            else break;
        }
        return r;
    }

    int findRight(int i,int j,int[][] qipan){
        int m=qipan[0].length;
        if(j==m-1||qipan[i][j]==0) return 0;
        int r=0;
        for(int jj=j+1;jj<m;jj++){
            if(qipan[i][jj]==qipan[i][j]) r++;
            else break;
        }
        return r;
    }


    void answer(int[][] qipan){
        List<int[]> r=new ArrayList<int[]>();
        int n=qipan.length;
        int m=qipan[0].length;
        int t;
        int[] tt;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                t=findRight(i,j,qipan);
                if(t>1){
                    for(int jj=0;jj<=t;jj++){
                        tt=new int[2];
                        tt[0]=i;
                        tt[1]=j+jj;
                        if(!inr(r,tt)) r.add(tt);
                    }
                }
                t=findBottom(i,j,qipan);
                if(t>1){
                    for(int ii=0;ii<=t;ii++){
                        tt=new int[2];
                        tt[0]=i+ii;
                        tt[1]=j;
                        if(!inr(r,tt)) r.add(tt);
                    }
                }
            }
        }
        for(int[] wc:r){
            qipan[wc[0]][wc[1]]=0;
        }
    }
     boolean inr(List<int[]> r,int[] t){
        for(int[] a:r){
            if(a[0]==t[0]&&a[1]==t[1]) return true;
        }
        return false;
    }

}