import java.util.Scanner;

public class s201804_360test {
    public static void main(String[] args) {
        Scanner var1 = new Scanner(System.in);
        int L = var1.nextInt();
        int R = var1.nextInt();
        var1.close();
        answer(L,R);
    }
    static void answer(int L,int R){
        double l=L;
        double r=R;
        double pai=3.1415926;
        double c=2*pai*r;
        while(l-c>0) l=l-c;
        double y0=R*Math.sin(2*pai-l/r);
        double x0=R*Math.cos(2*pai-l/r);
        String Y0=String.format("%.3f",y0);
        String X0=String.format("%.3f",x0);
        System.out.println(X0+" "+Y0);
        double y1=R*Math.sin(l/r);
        double x1=R*Math.cos(l/r);
        String Y1=String.format("%.3f",y1);
        String X1=String.format("%.3f",x1);
        System.out.println(X1+" "+Y1);
    }
}