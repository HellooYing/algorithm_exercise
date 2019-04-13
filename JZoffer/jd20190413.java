import java.util.*;

public class jd20190413 {
    static class Node{
        int val = 0;
        int distance=100001;
        List<Node> side=new ArrayList<>();
        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            String r=val+" "+distance+" ";
            for (int i = 0; i < side.size() ; i++) {
                r=r.concat(String.valueOf(side.get(i).val)).concat(" ");
            }
            return r;
        }
    }


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Node> all=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            all.add(new Node(i+1));
        }
        all.get(0).distance=0;
        List<int[]> sides=new ArrayList<>();
        for (int i = 0; i <n-1 ; i++) {
            int n1=in.nextInt();
            int n2=in.nextInt();
            if(!connect(n1,n2,all)){
                int[] t=new int[2];
                t[0]=n1;
                t[1]=n2;
                sides.add(t);
            }
        }
        in.close();
        while(sides.size()!=0){
            for (int i = 0; i <sides.size() ; i++) {
                if(connect(sides.get(i)[0],sides.get(i)[1],all)){
                    sides.remove(i);
                    i--;
                }
            }
        }
//        for (int i = 0; i <n; i++) {
//            System.out.println(all.get(i).toString());
//        }
        answer2(all);
    }
    static void answer2(List<Node> all){
        Node node=all.get(0);
        int max=num(node.side.get(0));
        for (int i = 1; i <node.side.size() ; i++) {
            int t=num(node.side.get(i));
            if(max<t) max=t;
        }
        System.out.println(max);
    }
    static int num(Node node){
        if(node.side.size()==0) return 1;
        int r=1;
        for (int i = 0; i <node.side.size() ; i++) {
            r=r+num(node.side.get(i));
        }
        return r;
    }

    static void answer(List<Node> all){
        int result=0;
        while(all.get(0).side.size()!=0){//当还有人没逃出来时
            result++;
            for (int i = 0; i < all.get(0).side.size(); i++) {//对每个与出口相连的节点
                Node node=all.get(0).side.get(i);
                if(node.side.size()==0){//该节点通道已没人需要
                    all.get(0).side.remove(node);
                    continue;
                }
                Node deepest=node.side.get(0);
                int depth=depth(deepest);
                for (int j = 1; j <node.side.size(); j++) {//选择深度最大的先行，更新节点深度
                    int t=depth(node.side.get(j));
                    if(depth<t){
                        deepest=node.side.get(j);
                        depth=t;
                    }
                }
                changedistance(deepest);
                for (int j = 1; j <node.side.size(); j++){//将其他通道练到深度最大的点上
                    if(node.side.get(j)!=deepest){
                        deepest.side.add(node.side.get(j));
                    }
                }
                all.get(0).side.remove(node);
                all.get(0).side.add(i,deepest);
            }
        }
        System.out.println(result);
    }
    static void changedistance(Node node){
        node.distance--;
        for (int i = 0; i <node.side.size() ; i++) {
            changedistance(node.side.get(i));
        }
    }
    static int depth(Node node){
        if(node.side.size()==0) return node.distance;
        else{
            int max=node.distance;
            for (int i = 0; i <node.side.size() ; i++) {
                int t=depth(node.side.get(i));
                if(max<t) max=t;
            }
            return max;
        }
    }
    static boolean connect(int n1,int n2,List<Node> all){
        Node node1=all.get(n1-1);
        Node node2=all.get(n2-1);
        if(node1.distance!=100001||node2.distance!=100001){
            //如果有已连接到安全出口的情况
            if(node1.distance!=100001&&node2.distance!=100001){
                if(node1.distance+1<node2.distance) {
                    node1.side.add(node2);
                    node2.distance=node1.distance+1;
                }
                if(node2.distance+1<node1.distance) {
                    node2.side.add(node1);
                    node1.distance=node2.distance+1;
                }
            }
            else if(node1.distance!=100001){
                node1.side.add(node2);
                node2.distance=node1.distance+1;
            }
            else if(node2.distance!=100001){
                node2.side.add(node1);
                node1.distance=node2.distance+1;
            }
        }
        else{//两个孤零零的点连接
            return false;
        }
        return true;
    }
}
