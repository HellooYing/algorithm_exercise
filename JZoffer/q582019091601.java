import java.io.IOException;
import java.util.*;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class q582019091601 {
    class Node{
        int val;
        q582019091601.Node left;
        q582019091601.Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private q582019091601.Node createBinaryTreeByArray(Integer[] array, int index)
    {
        q582019091601.Node tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new q582019091601.Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public int levelOrder(q582019091601.Node root){
        int[][] a=get(root);
        int maxLevel=0;
        double maxValue=avl(a[0]);
        for (int i = 1; i < a.length; i++) {
            double v=avl(a[i]);
            if(maxValue<v){
                maxLevel=i;
                maxValue=v;
            }
        }
        return maxLevel+1;
    }
    public static double avl(int[] a){
        double r=0;
        for (int i = 0; i <a.length ; i++) {
            r+=a[i];
        }
        return r/a.length;
    }
    public static int[][] get(q582019091601.Node root){
        //按层的二叉树

        List<List<Integer>> r=new ArrayList<List<Integer>>();
        q582019091601.Node last,nlast=root;
        Deque<q582019091601.Node> q=new LinkedList<q582019091601.Node>();
        q.offer(root);
        List<Integer> rr=new ArrayList<Integer>();
        while(!q.isEmpty()){
            last=q.poll();
            rr.add(last.val);
            if(last.left!=null) q.offer(last.left);
            if(last.right!=null) q.offer(last.right);
            if(last==nlast){
                r.add(rr);
                rr=new ArrayList<Integer>();
                nlast=q.peekLast();
            }
        }
        if(rr.size()>0) r.add(rr);
        int[][] a=new int[r.size()][];
        int[] b;
        for(int i=0;i<r.size();i++){
            b=new int[r.get(i).size()];
            for(int j=0;j<r.get(i).size();j++){
                b[j]=r.get(i).get(j);
            }
            a[i]=b;
        }
        return a;
    }


    public q582019091601.Node createTree(int[] array){
        List<q582019091601.Node> nodeList=new LinkedList<q582019091601.Node>();

        for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new q582019091601.Node(array[nodeIndex]));
        }
        for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //防止是非完全二叉树
            if((parentIndex*2+2)<array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void q582019091601(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer [] array = new Integer[n];
        for(int i = 0;i < n;i++){
            String value =scanner.next();
            if(value.equals( "null" )){
                array[i]=null;
            }else{
                array[i] = Integer.valueOf( value );
            }

        }
        q582019091601 solution = new q582019091601();
        q582019091601.Node root =solution.createBinaryTreeByArray(array,0);
        int level = solution.levelOrder( root );
        System.out.println(level);

    }
}
