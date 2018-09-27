import java.util.ArrayList;
public class isValid {
    public static void main(String[] args) throws Exception {
        String s ="{[]}";
        System.out.println(new isValid().answer(s));
    }
    public Boolean answer(String s) {
        int l=s.length();
        char a;
        int ql;
        char qe;
        ArrayList<Character> q=new ArrayList<Character>();
        if(l==0) return true;
        q.add(s.charAt(0));
        for(int i=1;i<l;i++){
            if(q.size()==0){
                q.add(s.charAt(i));
                continue;
            }
            a=s.charAt(i);
            ql=q.size()-1;
            qe=q.get(ql);
            if(a=='('){
                if(qe==')'){
                    q.remove(ql);
                    continue;
                }
                else if(qe=='('||qe=='['||qe=='{'){
                    q.add(a);
                    continue;
                }
                else {
                    return false;
                }
            }
            else if(a==')'){
                if(qe=='('){
                    q.remove(ql);
                    continue;
                }
                else {
                    return false;
                }
            }
            else if(a=='['){
                if(qe==']'){
                    q.remove(ql);
                    continue;
                }
                else if(qe=='('||qe=='['||qe=='{'){
                    q.add(a);
                    continue;
                }
                else {
                    return false;
                }
            }
            else if(a==']'){
                if(qe=='['){
                    q.remove(ql);
                    continue;
                }
                else {
                    return false;
                }
            }
            else if(a=='{'){
                if(qe=='}'){
                    q.remove(ql);
                    continue;
                }
                else if(qe=='('||qe=='['||qe=='{'){
                    q.add(a);
                    continue;
                }
                else {
                    return false;
                }
            }
            else if(a=='}'){
                if(qe=='{'){
                    q.remove(ql);
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        if(q.size()==0) return true;
        else return false;
    }
}