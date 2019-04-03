import java.util.Scanner;

public class s2019040301 {
    public static void main(String[] var0) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                a[i][j]=scanner.nextInt();
            }
        }
        scanner.close();
        answer(a);
    }
    static void answer(int[][] a){
        for(int i=0;i<a.length;i++){
            int[] b=a[i];
            int r=b[3];
            r+=Math.min(b[0],b[2]);
            r+=b[1]/2;
            int bn=b[1]%2;
            int an=0,cn=0;
            if(b[0]>b[2]) an=b[0]-b[2];
            else cn=b[2]-b[0];
            if(an>0&&bn>0){
                r+=Math.min(an/2,bn);
                if(an/2>bn){
                    an-=2*bn;
                    bn=0;
                }
                else if(an/2<bn){
                    an=0;
                    bn=bn-an/2;
                }
                else{
                    an=0;
                    bn=0;
                }
            }
            if(an>=4){
                r+=an/4;
            }
            System.out.println(r);
        }
    }
}
