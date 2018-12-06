import java.util.*;

public class csp2018091 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        int[] cj=new int[n];
        int i=0;
        while (i<n) {
            cj[i]=sc.nextInt();  
            i++;
        }
        sc.close();
        int[] r=new int[n];
        r[0]=(int)((cj[1]+cj[0])/2);
        r[n-1]=(int)((cj[n-1]+cj[n-2])/2);
        for(i=1;i<n-1;i++){
            r[i]=(int)((cj[i]+cj[i-1]+cj[i+1])/3);
        }
        for(int j:r){
            System.out.print(j);System.out.print(" ");
        }
    }
}