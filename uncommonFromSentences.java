import java.util.*;
public class uncommonFromSentences {
    public static void main(String[] args) throws Exception {
        String c,b;
        c="apple apple";
        b= "banana";
        String[] a = new uncommonFromSentences().answer(c,b);
        for(String ss:a){
            System.out.println(ss);
        }
    }

    public String[] answer(String A, String B) {
        List<String> r= new ArrayList();
        String[] a=A.split(" ");
        String[] b=B.split(" ");
        List<String> list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        String[] c=(String[])list.toArray(new String[list.size()]);
        if(c.length<=1) return c;
        Arrays.sort(c);
        for(int i=1;i<c.length-1;i++){
            if((!c[i].equals(c[i-1]))&&(!c[i].equals(c[i+1]))){
                r.add(c[i]);
            }
        }
        if(!c[0].equals(c[1])) r.add(c[0]);
        if(!c[c.length-1].equals(c[c.length-2])) r.add(c[c.length-1]);
        String[] result;
        result=(String[])r.toArray(new String[r.size()]);
        return result;
    }
}