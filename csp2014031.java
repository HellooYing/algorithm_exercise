import java.util.*;

public class csp2014031 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int i=sc.nextInt();
        int[] a=new int[i];
        for(int j=0;j<i;j++){
            a[j]=sc.nextInt();
        }
        sc.close();
        System.out.println(new csp2014031().answer(a));
    }
    int answer(int[] a){
        List<Integer> r=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            if(r.contains(-a[i])){
                r.remove(r.indexOf(-a[i]));
            }
            else{
                r.add(a[i]);
            }
        }
        return (a.length-r.size())/2;
    }
}