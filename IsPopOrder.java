import java.util.*;

public class IsPopOrder {
    public static void main(String[] args) throws Exception {
        int[] pushA={};
        int[] popA={};
        System.out.println(new IsPopOrder().answer(pushA,popA));
    }

    public boolean answer(int [] pushA,int [] popA){
        Stack<Integer> st=new Stack<Integer>();
        int i=0;
        int j=0;
        //直接进行模拟，根据popA想要的，如果栈为空或栈顶元素不是popA想要的，就入栈一个pushA
        //如果pushA的最后一个还不是popA想要的，返回false
        while(i<=pushA.length){
            if(st.empty()||st.peek()!=popA[j]){
                if(i==pushA.length&&j!=popA.length) {return false;}
                else if(i==pushA.length&&j==popA.length) return true;
                st.push(pushA[i]);
                i++;
            }
            else{
                st.pop();
                j++;
            }
        }
        return false;
    }
}