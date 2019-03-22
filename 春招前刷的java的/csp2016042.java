import java.util.*;

public class csp2016042 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int[][] r=new int[15][10];
        int[][] fk=new int[4][4];
        int i=0;
        while (i<15) {
            r[i][0]=sc.nextInt();
            r[i][1]=sc.nextInt();
            r[i][2]=sc.nextInt();
            r[i][3]=sc.nextInt();
            r[i][4]=sc.nextInt();
            r[i][5]=sc.nextInt();
            r[i][6]=sc.nextInt();
            r[i][7]=sc.nextInt();
            r[i][8]=sc.nextInt();
            r[i][9]=sc.nextInt();
            i++;
        }
        i=0;
        while(i<4){
            fk[i][0]=sc.nextInt();
            fk[i][1]=sc.nextInt();
            fk[i][2]=sc.nextInt();
            fk[i][3]=sc.nextInt();
            i++;
        }
        int left=sc.nextInt();
        sc.close();
        new csp2016042().answer(r,fk,left);
        for(i=0;i<15;i++){
            for(int j=0;j<10;j++){
                System.out.print(r[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    boolean overlapping(int[][] a,int[][] b){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]==1&&b[i][j]==1) return true;
            }
        }
        return false;
    }

    int[][] getfk2(int[][] r,int l,int top,int left){
        int[][] fk2=new int[l][4];
        int ii=l-1,jj=0;
        for(int i=top;i>top-l;i--){
            jj=0;
            for(int j=left-1;j<left+3;j++){
                fk2[ii][jj]=r[i][j];
                jj++;
            }
            ii--;
        }
        return fk2;
    }

    void setfk(int[][] r,int[][] fk,int top,int left){
        int ii=fk.length-1,jj=0;
        for(int i=top;i>top-fk.length;i--){
            jj=0;
            for(int j=left-1;j<left+3;j++){
                if(r[i][j]==0) r[i][j]=fk[ii][jj];
                jj++;
            }
            ii--;
        }
    }

    public void answer(int[][] r,int[][] fk,int left){
        int top,bottom;
        int flag=0;
        for(top=0;top<15;top++){
            for(int j=0;j<10;j++){
                if(r[top][j]==1) {flag=1;break;}
            }
            if(flag==1) break;
        }
        flag=0;
        for(bottom=0;bottom<4;bottom++){
            for(int j=0;j<4;j++){
                if(fk[3-bottom][j]==1) {flag=1;break;}
            }
            if(flag==1) break;
        }
        int[][] t=fk;
        fk=new int[4-bottom][4];
        for(int i=0;i<4-bottom;i++){
            for(int j=0;j<4;j++){
                fk[i][j]=t[i][j];
            }
        }
        
        while(top<15&&!overlapping(fk,getfk2(r,fk.length,top,left))){
            top++;
        }
        setfk(r,fk,top-1,left);
    }
}