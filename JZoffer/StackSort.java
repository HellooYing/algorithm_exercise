import java.util.Stack;

/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(0);
        stack.push(2);
        sort(stack);
        System.out.println(stack);
    }
    private static void sort(Stack<Integer> stack){
        Stack<Integer> stack2=new Stack<>();
        int tmp;
        while (stack.size()!=0){
            tmp=stack.pop();
            if(stack2.size()==0||stack2.peek()>tmp){
                stack2.push(tmp);
            }
            else{
                while(stack2.size()!=0&&stack2.peek()<tmp) stack.push(stack2.pop());
                stack2.push(tmp);
            }
        }
        while (stack2.size()!=0) stack.push(stack2.pop());
    }
}
