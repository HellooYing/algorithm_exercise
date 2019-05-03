import java.util.*;

public class BinarySearchTree<T extends Comparable<? super T>> {
    BinaryNode<T> root;

    static public class BinaryNode<T>{
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;
        public BinaryNode(T data){
            this.data=data;
        }
        public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public BinarySearchTree(){
        root=null;
    }

    public BinarySearchTree(BinaryNode<T> root){
        root=root;
    }

    public boolean contains(T t){
        return contains(t,root);
    }

    public boolean contains(T t,BinaryNode<T> node){
        if(node==null) return false;
        int result=t.compareTo(node.data);
        if(result==0) return true;
        else if(result>0) return contains(t,node.right);
        else return contains(t,node.left);
    }

    public void clear(){
        root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean insert(T t){
        if(root==null){
            root=new BinaryNode<T>(t);
            return true;
        }
        BinaryNode<T> node=root;
        while(true){
            int result=t.compareTo(node.data);
            if(result>0){
                if(node.right==null){
                    node.right=new BinaryNode<T>(t);
                    return true;
                }
                else{
                    node=node.right;
                }
            }
            else if(result<0){
                if(node.left==null){
                    node.left=new BinaryNode<T>(t);
                    return true;
                }
                else{
                    node=node.left;
                }
            }
            else return false;
        }
    }

    public boolean delete(T t){
        if(root==null){
            return false;
        }
        BinaryNode<T> father=root;
        BinaryNode<T> node=root;
        boolean LeftOrRight;
        if(t.compareTo(root.data)==0){//如果要删去的是根节点值
            if(root.left==null&&root.right==null){//根节点无左右子树则直接清空,返回
                root=null;
                return true;
            }
            else if(root.left==null){//只有左子树或只有右子树，则令根节点为左子节点或右子节点，返回
                root=root.right;
                return true;
            }
            else if(root.right==null){
                root=root.left;
                return true;
            }
            else{//左右子树都存在
                BinaryNode<T> LeftOnRightSonTree=root.right;
                if(LeftOnRightSonTree.left==null){//右子节点就是右子树上的最小节点
                    root=LeftOnRightSonTree;//根节点即为右子节点
                    LeftOnRightSonTree.left=node.left;//新的根节点的左子树为原来根节点的左子树
                    return true;//返回
                }
                else{//右子节点不是右子树上的最小节点
                    while(LeftOnRightSonTree.left.left!=null) {//则找到右子树上最小节点的父节点
                        LeftOnRightSonTree = LeftOnRightSonTree.left;
                    }
                    root=LeftOnRightSonTree.left;//根节点为右子树上的最小节点
                    LeftOnRightSonTree.left=LeftOnRightSonTree.left.right;
                    //最小节点的父节点的左子节点从原最小节点变为原最小节点的右子节点
                    root.left=node.left;//新根节点的左子树和右子树为原根节点的左子树和右子树
                    root.right=node.right;
                    return true;//返回
                }
            }
        }
        else if(t.compareTo(root.data)>0){//如果要删除的节点大于根节点
            node=root.right;//令node为右子节点
            LeftOrRight=false;
        }
        else {
            node=root.left;//否则为左子节点
            LeftOrRight=true;
        }
        while(true){//循环寻找要删除的节点，同时记录其父节点
            if(node==null) return false;
            int result=t.compareTo(node.data);
            if(result==0){//找到了要删除的节点
                if(node.left==null&&node.right==null){//当前节点为叶子节点，直接令父节点的对应指针为空，返回
                    if(LeftOrRight==false) father.right=null;
                    else father.left=null;
                    return true;
                }
                else if(node.left==null){//只有右子树，则父节点直接连右子节点，返回
                    if(LeftOrRight==true){
                        father.left=node.right;
                    }
                    else{
                        father.right=node.right;
                    }
                    return true;
                }
                else if(node.right==null){//只有左子树，则父节点直接连左子节点，返回
                    if(LeftOrRight==true){
                        father.left=node.left;
                    }
                    else{
                        father.right=node.left;
                    }
                    return true;
                }
                else{//左右子树都有
                    BinaryNode<T> LeftOnRightSonTree=node.right;
                    if(LeftOnRightSonTree.left==null){//右子节点就是最小节点时，
                        if(LeftOrRight==true){
                            father.left=LeftOnRightSonTree;//被删除节点的父节点接右子节点
                            LeftOnRightSonTree.left=node.left;//右子节点左指针接要删除的节点的左子节点
                        }
                        else{
                            father.right=LeftOnRightSonTree;
                            LeftOnRightSonTree.left=node.left;
                        }
                        return true;//返回
                    }
                    else{//否则，找到最小节点的父节点
                        while(LeftOnRightSonTree.left.left!=null){
                            LeftOnRightSonTree=LeftOnRightSonTree.left;
                        }
                        if(LeftOrRight==true){
                            father.left=LeftOnRightSonTree.left;//被删除节点的父节点接最小节点
                            LeftOnRightSonTree.left=LeftOnRightSonTree.left.right;
                            //最小节点的父节点的左指针指向最小节点的右子节点
                            //因为最小节点是右子树最左边的节点，所以它一定是父节点的左子节点，也一定没有左节点
                            father.left.left=node.left;
                            //顶替位置的节点（原最小节点）的左右指针分别指向原节点的左右子树
                            father.left.right=node.right;
                        }
                        else if(LeftOrRight==false){
                            father.right=LeftOnRightSonTree.left;
                            LeftOnRightSonTree.left=LeftOnRightSonTree.left.right;
                            father.right.left=node.left;
                            father.right.right=node.right;
                        }
                        return true;//返回
                    }
                }
            }
            if(result>0){//如果要删除的节点大于当前节点，则去右子树中寻找
                father=node;
                node=node.right;
                LeftOrRight=false;
            }
            else{//如果要删除的节点小于当前节点，则去左子树中寻找
                father=node;
                node=node.left;
                LeftOrRight=true;
            }
        }
    }

    public BinaryNode<T> findMinFather(BinaryNode<T> node){
        if(node==null) return null;
        if(node.left!=null){
            while(node.left.left!=null) node=node.left;
        }
        else{
            return null;
        }
        return node;
    }

    public BinaryNode find(T t){
        return find(t,root);
    }

    private BinaryNode find(T t,BinaryNode<T> node){
        if(node==null) return null;
        int result=t.compareTo(node.data);
        if(result==0) return node;
        else if(result>0) return find(t,node.right);
        else return find(t,node.left);
    }

    public List<List<T>> print(){
        List<List<T>> r=new ArrayList<>();
        if(root==null) return r;
        BinaryNode<T> last,nlast=root;
        Deque<BinaryNode<T>> q=new LinkedList<BinaryNode<T>>();
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

    public List<T> serialization(){
        List<T> list=new ArrayList<>();
        if(root==null) return list;
        serialization(list,root);
        return list;
    }

    private void serialization(List<T> list,BinaryNode<T> node){
        if(node.left!=null) serialization(list,node.left);
        list.add(node.data);
        if(node.right!=null) serialization(list,node.right);
    }

    public boolean test(){
        List<T> list=serialization();
        List<T> list1=new ArrayList<>();
        list1.addAll(list);
        Collections.sort(list1);
        if(list.equals(list1)) return true;
        else return false;
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree(new BinaryNode<Integer>(10));
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            int n = random.nextInt(100);
            int l1=tree.serialization().size();
            tree.insert(n);
            int l2=tree.serialization().size();
            if(!tree.test()||(l1!=l2-1&&l1!=l2)){
                System.out.println("wrong");
            }
        }
        System.out.println(tree.print());
        for (int i = 0; i < 30; i++) {
            int n = random.nextInt(100);
            int l1=tree.serialization().size();
            tree.delete(n);
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
