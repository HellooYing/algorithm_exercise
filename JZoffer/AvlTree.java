import java.util.*;

public class AvlTree<T extends Comparable<T>>{
    AvlNode root;
    public AvlTree(AvlNode<T> root){
        this.root=root;
    }
    public static class AvlNode<T extends Comparable<T>>{
        T data;
        int height=0;
        AvlNode<T> left;
        AvlNode<T> right;
        public AvlNode(T data){
            this.data=data;
            height=1;
        }
    }
    private int height(AvlNode node){
        if(node==null) return 0;
        else return node.height;
    }
    private AvlNode<T> LL(AvlNode<T> k2){
        AvlNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        return k1;
    }

    private AvlNode<T> RR(AvlNode<T> k1){
        AvlNode k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        return k2;
    }

    private AvlNode<T> LR(AvlNode<T> k3){
        k3.left=RR(k3.left);
        return LL(k3);
    }

    private AvlNode<T> RL(AvlNode<T> k1){
        k1.right=LL(k1.right);
        return RR(k1);
    }

    public void insert(T t){
        if(root==null){
            root=new AvlNode(t);
            return;
        }
        root=insert(t,root);
    }
    private AvlNode<T> insert(T t,AvlNode<T> node){
        if(node==null){
            return new AvlNode<T>(t);
        }
        int result=t.compareTo(node.data);
        if(result>0){
            node.right=insert(t,node.right);
            if(height(node.right)-height(node.left)==2){
                if(t.compareTo(node.right.data)>0){
                    node=RR(node);
                }
                else node=RL(node);
            }
        }
        else if(result<0){
            node.left=insert(t,node.left);
            if(height(node.left)-height(node.right)==2){
                if(t.compareTo(node.left.data)<0){
                    node=LL(node);
                }
                else node=LR(node);
            }
        }
        else{
            System.out.println("该元素已存在");
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    private AvlNode<T> getMax(AvlNode<T> node){
        if(node==null) return null;
        while(node.right!=null) node=node.right;
        return node;
    }

    private AvlNode<T> getMin(AvlNode<T> node){
        if(node==null) return null;
        while(node.left!=null) node=node.left;
        return node;
    }

    public void remove(T t){
        root=remove(t,root);
    }
    private AvlNode<T> remove(T t,AvlNode<T> node){
        if(node==null){
            return null;
        }
        int result=t.compareTo(node.data);
        if(result>0){
            node.right=remove(t,node.right);
            if(height(node.left)-height(node.right)==2){
                if(t.compareTo(node.left.data)<0){
                    node=LL(node);
                }
                else node=LR(node);
            }
        }
        else if(result<0){
            node.left=remove(t,node.left);
            if(height(node.right)-height(node.left)==2){
                if(t.compareTo(node.right.data)>0){
                    node=RR(node);
                }
                else node=RL(node);
            }
        }
        else{//当前节点就是要删去的节点
            if((node.left!=null)&&(node.right!=null)){
                AvlNode<T> last=node;
                if(height(node.left)>height(node.right)){
                    node=getMax(last.left);
                    remove(node.data,last.left);
                    node.left=last.left;
                    node.right=last.right;
                }
                else{
                    node=getMin(last.right);
                    remove(node.data,last.right);
                    node.left=last.left;
                    node.right=last.right;
                }
            }
            else{
                node=node.left==null?node.right:node.left;
            }
        }
        if(node!=null) node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public List<T> serialization(){
        List<T> list=new ArrayList<>();
        if(root==null) return list;
        serialization(list,root);
        return list;
    }

    private void serialization(List<T> list,AvlNode<T> node){
        if(node.left!=null) serialization(list,node.left);
        list.add(node.data);
        if(node.right!=null) serialization(list,node.right);
    }

    public List<List<T>> print(){
        List<List<T>> r=new ArrayList<>();
        if(root==null) return r;
        AvlNode<T> last,nlast=root;
        Deque<AvlNode<T>> q=new LinkedList<AvlNode<T>>();
        q.offer(root);
        List<T> rr=new ArrayList<>();
        while(!q.isEmpty()){
            last=q.poll();
            rr.add(last.data);
            if(last.left!=null) q.offer(last.left);
            if(last.right!=null) q.offer(last.right);
            if(last==nlast){
                r.add(rr);
                rr=new ArrayList<T>();
                nlast=q.peekLast();
            }
        }
        if(rr.size()>0) r.add(rr);
        return r;
    }
    public boolean test(){
        List<T> list=serialization();
        List<T> list1=new ArrayList<>();
        list1.addAll(list);
        Collections.sort(list1);
        if(!list.equals(list1)) return false;
        if(Math.abs(height(root.right)-height(root.left))>1) return false;
        return true;
    }
    public static void main(String[] args) {
        AvlTree tree=new AvlTree(new AvlNode<Integer>(10));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(50);
            int l1=tree.serialization().size();
            tree.insert(n);
            System.out.println(tree.print());
            int l2=tree.serialization().size();
            if(!tree.test()||(l1!=l2-1&&l1!=l2)){
                System.out.println("wrong");
                //System.out.println(tree.print());
            }
        }
        System.out.println(tree.print());
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(50);
            int l1=tree.serialization().size();
            tree.remove(n);
            int l2=tree.serialization().size();
            if(!tree.test()){
                System.out.println("wrong");
            }
            if(l1!=l2){
                System.out.println(n);
                System.out.println(tree.print());
            }
        }
    }
}
