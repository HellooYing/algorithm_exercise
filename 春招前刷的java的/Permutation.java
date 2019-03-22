import java.util.*;

public class Permutation {
    ArrayList<String> r;
    public static void main(String[] args) throws Exception {
        String a="acba";
        System.out.println(new Permutation().answer(a).toString());
    }
    public ArrayList<String> answer(String str){
        r=new ArrayList<String>();
        if(str.length()==0) return r;
        String[] t=str.split("");
        Arrays.sort(t);

        //1.递归方法
        //List<String> l = new ArrayList<String>();
        //Collections.addAll(l,t);
        //String s="";
        //dg(l,s);

        //2.非递归方法
        Boolean flag=false;
        String s="";
        for(int i=0;i<t.length;i++) s=s.concat(t[i]);
        r.add(s);
        while(flag==false){
            s=r.get(r.size()-1);
            t=s.split("");
            flag=true;
            for(int i=t.length-1;i>0;i--){
                if(t[i-1].charAt(0)<t[i].charAt(0)){
                    flag=false;
                    findnext(t,i);
                    break;
                }
            }
        }
        return r;
    }

    void findnext(String[] t,int i){
        for(int j=t.length-1;j>=i;j--){
            if(t[j].charAt(0)>t[i-1].charAt(0)){
                String tmp=t[j];
                t[j]=t[i-1];
                t[i-1]=tmp;
                break;
            }
        }
        reverse(t,i);
        String s="";
        for(String tt:t) s=s.concat(tt);
        if(!r.contains(s)) r.add(s);
    }

    void reverse(String[] t,int i){
        Stack<String> st=new Stack<String>();
        for(int j=t.length-1;j>=i;j--){
            st.push(t[j]);
        }
        for(int j=t.length-1;j>=i;j--){
            t[j]=st.pop();
        }
    }

    void dg(List<String> l,String s){
        String ss;
        if(l.size()==1){
            ss=s.concat(l.get(0));
            if(!r.contains(ss)) r.add(ss);
        }
        else{
            for(int i=0;i<l.size();i++){
                List<String> ll=new ArrayList<String>();
                ll.addAll(l);
                ll.remove(i);
                ss=s.concat(l.get(i));
                dg(ll,ss);
            }
        }
    }
}