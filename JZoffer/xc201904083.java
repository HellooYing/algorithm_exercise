import java.util.*;

public class xc201904083 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k=in.nextInt();
        String[] a=new String[k];
        for (int i = 0; i <k ; i++) {
            a[i]=in.next();
            if(a[i].charAt(a[i].length()-1)=='/'){
                a[i]=a[i].substring(0,a[i].length()-1);
            }
        }
        in.close();
        answer(a);
    }
    static void answer(String[] a){
        //先用hashmap计数，再记住数字，再结合数字做输出，规则是头尾固定1，中间++
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for (int i = 0; i <a.length ; i++) {
            if(map.get(a[i])==null) map.put(a[i],1);
            else map.put(a[i],map.get(a[i])+1);
        }
        LinkedList<String> r=new LinkedList<String>();
        for (int i = a.length-1; i >=0 ; i--) {
            int n=map.get(a[i]);
            map.put(a[i],n-1);
            String[] t=a[i].substring(1).split("/");
            String rr="1";
            for (int j = 1; j <t.length-1 ; j++) {
                rr=rr.concat(String.valueOf(n));
            }
            if(t.length>1) rr=rr.concat("1");
            r.addFirst(rr);
        }
        for(String s:r){
            System.out.print(s+" ");
        }
    }
}
