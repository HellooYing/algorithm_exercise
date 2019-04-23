import java.util.*;

public class mt201904232 {
    static class Node{
        int val;
        int color;
        boolean isBlackTreeRoot;
        int devidedMethodNum=1;
        List<Node> son=new ArrayList<>();
        Node father=null;
        Node(int val){
            this.val=val;
        }
        String printSon(){
            for (int i = 0; i <son.size() ; i++) {
                System.out.print(" "+son.get(i).val);
            }
            return "";
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        List<Node> tree=new ArrayList<>();
        Node root=new Node(0);
        tree.add(root);
        for (int i = 0; i < n-1; i++) {
            Node node=new Node(i+1);
            int father=in.nextInt();
            node.father=tree.get(father);
            node.father.son.add(node);
            tree.add(node);
        }
        for (int i = 0; i < n; i++) {
            tree.get(i).color=in.nextInt();
        }
        in.close();
        System.out.println(answer(tree));
    }
    static void printTree(Node root){
        System.out.println();
        System.out.print("值："+root.val+" 颜色："+root.color+
                " 是否为黑树："+root.isBlackTreeRoot+
                " 切分数量"+root.devidedMethodNum+
                " 子树值：");
        root.printSon();
        for (int i = 0; i <root.son.size() ; i++) {
            printTree(root.son.get(i));
        }
    }
    static int answer(List<Node> tree){
        if(tree.size()==0) return 0;
        //每棵子树有多少种符合要求的切分办法?子树是有白节点的还是没有白节点的？
        //先是子树切分办法相乘。再乘上根节点符合要求的切法数(初始为1，每棵黑树*2,最后乘以白树数)
        Node root=tree.get(0);
        isBlackTreeRoot(root);
        return root.devidedMethodNum;
    }
    static void isBlackTreeRoot(Node root){
        if(root.son.size()==0){
            if(root.color==1) root.isBlackTreeRoot=true;
            else root.isBlackTreeRoot=false;
            return;
        }
        for (int i = 0; i < root.son.size(); i++) {
            isBlackTreeRoot(root.son.get(i));
        }
        boolean isBlackTreeRoot=true;
        int devidedMethodNum=1;
        int whiteTreeNum=0;
        for (int i = 0; i < root.son.size(); i++) {
            if(root.son.get(i).isBlackTreeRoot==false){
                isBlackTreeRoot=false;
                whiteTreeNum++;
            }
            else{
                if(devidedMethodNum>1000000007){
                    devidedMethodNum%=1000000007;
                }
                devidedMethodNum*=2;
            }
        }
        if(root.color==1) devidedMethodNum*=whiteTreeNum;
        if(root.color==0) isBlackTreeRoot=false;
        root.isBlackTreeRoot=isBlackTreeRoot;
        root.devidedMethodNum=devidedMethodNum;
    }
}
