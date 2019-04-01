import java.math.BigInteger;
import java.util.*;

public class juzipipei {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine();
        String dict1=sc.nextLine();
        sc.close();
        String s=s1.substring(4,s1.length()-1);
        String[] dict=dict1.substring(6).split(",");
        for(int i=0;i<dict.length;i++){
            dict[i]=dict[i].substring(1,dict[i].length()-1);
        }
        new juzipipei().answer(s,dict);
    }
    void answer(String s,String[] dict){
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<dict.length;i++){
            if(s.indexOf(dict[i])==0){
                List<List<String>> t=new ArrayList<List<String>>();
                List<String> in=new ArrayList<String>();
                in.add(s.substring(0, dict[i].length()));
                t.add(in);
                t=dg(s.substring(dict[i].length()),dict,t);
                if(t.size()!=0){
                    result.addAll(t);
                }
            }
        }
        print(result);
    }
    List<List<String>> dg(String s,String[] dict,List<List<String>> r){
        if(s.length()==0) return r;
        List<List<String>> result=new ArrayList<List<String>>();
        boolean flag=false;
        for(int i=0;i<dict.length;i++){
            if(s.indexOf(dict[i])==0){
                flag=true;
                List<List<String>> t=new ArrayList<List<String>>();
                List<String> in=new ArrayList<String>();
                in.add(s.substring(0, dict[i].length()));
                t.add(in);
                if(dict[i].length()<s.length()){
                    t=dg(s.substring(dict[i].length()),dict,t);
                    for(int j=0;j<t.size();j++){
                        t.get(j).add(0,r.get(0).get(0));
                        result.add(t.get(j));
                    }
                }
            }
        }
        return result;
    }
    void print(List<List<String>> result){
        System.out.println("[");
        int i;
        for(i=0;i<result.size()-1;i++){
            int j;
            for(j=0;j<result.get(i).size()-1;j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.print(result.get(i).get(j)+", ");
        }
        int j;
        for(j=0;j<result.get(i).size()-1;j++){
            System.out.print(result.get(i).get(j)+" ");
        }
        System.out.print(result.get(i).get(j)+"]");
    }
}