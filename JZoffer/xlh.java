public class xlh {

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        String s = Serialize("",root);
        System.out.println(s);
        TreeNode a = Deserialize(s);
        String s2 = Serialize("",a);
        System.out.println(s2);
    }

    static String Serialize(String r,TreeNode root) {
        r=r.concat(Integer.toString(root.val)).concat("!");
        if(root.left!=null){
            r=Serialize(r,root.left);
        }
        else r=r.concat("#!");
        if(root.right!=null){
            r=Serialize(r,root.right);
        }
        else r=r.concat("#!");
        return r;
    }

    public static TreeNode Deserialize(String str){
        if(str.length()==0) return null;
        String[] s=str.split("!");
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        f2(s,1,root);
        return root;
    }

    static int f2(String[] s,int i,TreeNode father){
        if(i<s.length&&!s[i].equals("#")){
            TreeNode l=new TreeNode(Integer.parseInt(s[i]));
            father.left=l;
            i++;
            i=f2(s,i,l);
        }
        else i++;
        if(i<s.length&&!s[i].equals("#")){
            TreeNode r=new TreeNode(Integer.parseInt(s[i]));
            father.right=r;
            i++;
            i=f2(s,i,r);
        }
        else i++;
        return i;
    }

    // static String f(String r, TreeNode node) {
    //     r = r.concat(String.valueOf(node.val)).concat("!");
    //     if (node.left != null) r = f(r, node.left);
    //     else r = r.concat("#!");
    //     if (node.right != null) r = f(r, node.right);
    //     else r = r.concat("#!");
    //     return r;
    // }

    // static TreeNode Deserialize(String str) {
    //     String[] s = str.split("!");
    //     TreeNode root = new TreeNode(Integer.parseInt(s[0]));
    //     if (1 < s.length) f2(1, s, root);
    //     return root;
    // }

    // static int f2(int i, String[] s, TreeNode n) {
    //     if (i < s.length && !s[i].equals("#")) {
    //         n.left = new TreeNode(Integer.parseInt(s[i]));
    //         if (i + 1 < s.length) i = f2(i + 1, s, n.left);
    //         else i++;
    //     } else i++;
    //     if (i < s.length && !s[i].equals("#")) {
    //         n.right = new TreeNode(Integer.parseInt(s[i]));
    //         if (i + 1 < s.length) i = f2(i + 1, s, n.right);
    //         else i++;
    //     } else i++;
    //     return i;
    // }

}
