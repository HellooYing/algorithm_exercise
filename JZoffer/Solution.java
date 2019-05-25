import java.util.*;

public class Solution {
    static int i;
    public static void main(String[] args) {
        System.out.println(Solution.i);
        new Solution().i=2;
        System.out.println(Solution.i);
//        TreeNode root=new TreeNode(-2);
//        root.right=new TreeNode(-3);
//        System.out.println(hasPathSum(root,-5));
    }
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        TreeNode last=root;
//        TreeNode node=root;
//        Queue<TreeNode> q=new LinkedList<TreeNode>();
//        if(node!=null) q.offer(node);
//    }
static boolean flag=false;
    static public boolean hasPathSum(TreeNode root, int sum) {
        f(root,0,sum);
        return flag;
    }
    static void f(TreeNode node,int r,int sum){
        if(node==null) return;
        r+=node.val;
        if(node.left==null&&node.right==null){
            if(r==sum) flag=true;
            return;
        }
        if(node.left!=null) f(node.left,r,sum);
        if(node.right!=null) f(node.right,r,sum);
    }
static public int minDepth(TreeNode root) {
    if(root==null) return 0;
    if(root.left==null&&root.right==null) return 1;
    if(root.left!=null&&root.right==null) {
        return minDepth(root.left)+1;
    }
    if(root.left==null&&root.right!=null) {
        return minDepth(root.right)+1;
    }
    int l=minDepth(root.left);
    int r=minDepth(root.right);
    int m=Math.min(l,r);
    return m+1;
}
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right!=null) return false;
        if(root.left!=null&&root.right==null) return false;
        return isSymmetricDg(root.left,root.right);
    }
    boolean isSymmetricDg(TreeNode l,TreeNode r){
        if(l==null&&r==null) return true;
        if(l==null&&r!=null) return false;
        if(l!=null&&r==null) return false;
        if(l.val==r.val&&isSymmetricDg(l.right,r.left)&&isSymmetricDg(l.left,r.right)) return true;
        else return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        String a=Serialize(p);
        String b=Serialize(q);
        if(a.equals(b)) return true;
        else return false;
    }
    String Serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int count = (1 << treeDepth(root)) - 1;//计数，拿到此树的深度后计算对应完全二叉树节点数
        list.add(root);
        count--;
        TreeNode tmpNode = null;

        //层次遍历二叉树，开始序列化
        while(list.size() > 0 && count >= 0){
            tmpNode = list.remove(0);
            if(tmpNode != null){
                sb.append(tmpNode.val+",");
                list.add(tmpNode.left);
                list.add(tmpNode.right);
            }else{
                sb.append("#,");//#作为空节点占位符
                list.add(null);
                list.add(null);
            }
            count --;
        }
        return sb.toString();
    }
    int treeDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }else{
            int lDepth = treeDepth(root.left) + 1;
            int rDepth = treeDepth(root.right) + 1;
            return lDepth > rDepth ? lDepth : rDepth;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for(int i=m+n+1;i>=0;i--){
            if(n<0||(m>=0&&nums1[m]>nums2[n])){
                nums1[i]=nums1[m];
                m--;
            }
            else{
                nums1[i]=nums2[n];
                n--;
            }
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> s=new HashSet<>();
        ListNode last=head;
        s.add(head.val);
        ListNode node=head.next;
        while(node!=null){
            if(s.contains(node.val)){
                last.next=node.next;
                node=node.next;
            }
            else{
                s.add(node.val);
                last=last.next;
                node=node.next;
            }
        }
        return head;
    }
    public int mySqrt(int x) {
        if(x==1) return 1;
        int result=x/2;
        int old=0;
        int left=0;
        int right=x;
        long thisDiff=x-result*result;
        while(!(thisDiff>0&&x-(result+1)*(result+1)<0)&&old!=result){
            if(thisDiff<0){
                right=result;
                old=result;
                result=(left+right)/2;
            }
            else if(thisDiff==0){
                return result;
            }
            else{
                left=result;
                old=result;
                result=(left+right)/2;
            }
            thisDiff=x-result*result;
        }
        return result;
    }
    public String addBinary(String a, String b) {
        boolean jw=false;
        StringBuilder r=new StringBuilder();
        if(a.length()<b.length()){
            String t=a;
            a=b;
            b=t;
        }
        int t=0;
        int i;
        for (i = 1; i <= a.length(); i++) {
            if(jw==true) t++;
            if(a.charAt(a.length()-i)=='1') t++;
            if(i<=b.length()&&b.charAt(b.length()-i)=='1') t++;
            switch (t){
                case 0:
                    r.insert(0,'0');
                    jw=false;
                    t=0;
                    break;
                case 1:
                    r.insert(0,'1');
                    jw=false;
                    t=0;
                    break;
                case 2:
                    r.insert(0,'0');
                    jw=true;
                    t=0;
                    break;
                case 3:
                    r.insert(0,'1');
                    jw=true;
                    t=0;
                    break;
            }
        }
        if(jw==true) r.insert(0,'1');
        return r.toString();
    }
}
