import java.util.*;
public class ks201904131 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        in.close();
        System.out.println(answer(s1,s2));
    }
    static int[][] d;
    static int answer(String s1,String s2){
        d=new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            d[i][0]=i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            d[0][i]=i;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    d[i][j]=Math.min(Math.min(d[i-1][j-1],d[i][j-1]+1),d[i-1][j]+1);
                }
                else{
                    d[i][j]=Math.min(Math.min(d[i-1][j-1]+1,d[i][j-1]+1),d[i-1][j]+1);
                }
            }
        }
        return d[s1.length()][s2.length()];
    }

}
