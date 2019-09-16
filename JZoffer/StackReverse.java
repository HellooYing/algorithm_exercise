import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class StackReverse {
    public static void main(String[] args) {
        int[] a=new int[]{7279,9784,9387,6620};
        StackReverse stackReverse=new StackReverse();
        Arrays.toString(stackReverse.reverseStack(a,a.length));
    }
    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<A.length;i++){
            st.push(A[i]);
        }
        System.out.println(st);
        reverse(st);
        System.out.println(st);
        for(int i=0;i<st.size();i++){
            A[i]=st.pop();
        }
        return A;
    }

    private void reverse(Stack<Integer> st){
        if(st.size()==0) return;
        int n=getStackBottom(st);
        reverse(st);
        st.push(n);
    }

    private int getStackBottom(Stack<Integer> st){
        int n=st.pop();
        if(st.size()==0) return n;
        else{
            int r=getStackBottom(st);
            st.push(n);
            return r;
        }
    }
}
