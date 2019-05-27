import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    /***
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     */
    public static void main(String[] args) {
        System.out.println(new generateParenthesis().answer(3));
    }
    //想法是，记录当前使用的左括号和右括号数量，相等则只能左括号，左括号多则可以两种，递归向下，然后加入全局变量的队列
    List<String> r;
    public List<String> answer(int n) {
        r=new ArrayList<>();
        dg(0,0,n,"");
        return r;
    }
    void dg(int leftNum,int rightNum,int n,String s){
        if(leftNum==n&&rightNum==n){
            r.add(s);
            return;
        }
        if(leftNum==rightNum){
            dg(leftNum+1,rightNum,n,s.concat("("));
        }
        else if(leftNum==n){
            dg(leftNum,rightNum+1,n,s.concat(")"));
        }
        else{
            dg(leftNum+1,rightNum,n,s.concat("("));
            dg(leftNum,rightNum+1,n,s.concat(")"));
        }
    }
}
