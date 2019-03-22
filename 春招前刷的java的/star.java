//马莹莹 20164465 计1606
import java.util.*;

public class star {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        sc.close();
        new star().answer(a);
    }

    public void answer(int a){
        int s=1;
        int i;
        int k;
        if(a%2!=0) k=a;
        else k=a-1;
        for(i=1;i<=a/2;i++){
            for(int jj=0;jj<(k-s)/2;jj++)
                System.out.print(" ");
            for(int j=0;j<s;j++){
                System.out.print("*");
            }
            for(int jj=0;jj<(k-s)/2;jj++)
                System.out.print(" ");
            System.out.println();
            s=s+2;
        }
        if(a%2!=0){
            for(int j=0;j<s;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        s=s-2;
        i--;
        for(;i>0;i--){
            for(int jj=0;jj<(k-s)/2;jj++)
                System.out.print(" ");
            for(int j=0;j<s;j++){
                System.out.print("*");
            }
            for(int jj=0;jj<(k-s)/2;jj++)
                System.out.print(" ");
            System.out.println();
            s=s-2;
        }
    }
}