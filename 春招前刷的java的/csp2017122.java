import java.util.*;

public class csp2017122 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int k= sc.nextInt();
        sc.close();
        System.out.println(new csp2017122().answer(n,k));
    }
    int tt(List<Integer> children,int k,int bs){
        for(int i=0;i<children.size();i++){
            if(children.size()==1) break;
            if(bs%k==0||bs%10==k) {children.remove(i);i--;}
            bs++;
        }
        return bs;
    }
    public int answer(int n,int k){
        List<Integer> children=new ArrayList<Integer>();
        int bs=1;
        for(int i=1;i<=n;i++) children.add(i);
        while(children.size()>1){
            bs=tt(children,k,bs);
        }
        return children.get(0);
    }
}