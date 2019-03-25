import java.util.*;
public class Serialize {
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

    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        return Deserialize(str.split(","), 0);
    }

    TreeNode Deserialize(String[] strings, int index){
        TreeNode newNode = null;
        if(index < strings.length){
            if(!strings[index].equals("#")){
                newNode = new TreeNode(Integer.parseInt(strings[index]));
                newNode.left = Deserialize(strings, 2 * index + 1);
                newNode.right = Deserialize(strings, 2 * index + 2);
            }
        }
        return newNode;
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
}