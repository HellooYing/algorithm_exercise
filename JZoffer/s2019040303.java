import java.util.*;

public class s2019040303 {
    public static void main(String[] var0) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            a.add(scanner.nextInt());
        }
        scanner.close();
        answer(a);
    }
    static void answer(List<Integer> a){
        int min=f(a);
        for(int i=1;i<a.size();i++){
            xz(a);
            int t=f(a);
            if(min>t){
                min=t;
            }
        }
        System.out.println(min);
    }
    static void xz(List<Integer> a){
        int t=a.get(0);
        a.remove(0);
        a.add(t);
    }
    
    static int f(List<Integer> a){
        int r=0;
        for(int i=0;i<a.size();i++){
            r+=Math.abs(a.get(i)-i-1);
        }
        return r;
    }
}
