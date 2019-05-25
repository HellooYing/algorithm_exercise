public class RBTree<T extends Comparable<T>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    RBNode<T> root;

    public static class RBNode<T extends Comparable<T>> {
        T data;
        boolean color;
        RBNode left;
        RBNode right;
        RBNode father;

        public RBNode(T data, boolean color, RBNode<T> father, RBNode<T> left, RBNode<T> right) {
            this.data = data;
            this.color = color;
            this.father = father;
            this.left = left;
            this.right = right;
        }

        public RBNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + data + " " + (this.color == RED ? "red" : "black");
        }
    }

    private RBNode<T> fatherOf(RBNode<T> node) {
        return node != null ? node.father : null;
    }

    private boolean colorOf(RBNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBNode<T> node) {
        return ((node != null) && (node.color == RED)) ? true : false;
    }

    private boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBNode<T> node) {
        if (node != null)
            node.color = BLACK;
    }

    private void setRed(RBNode<T> node) {
        if (node != null)
            node.color = RED;

    }

    private void setfather(RBNode<T> node, RBNode<T> father) {
        if (node != null)
            node.father = father;
    }

    private void setColor(RBNode<T> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    private RBNode<T> getMin(RBNode<T> node) {
        if (node == null) {
            return null;
        } else {
            while (node.left != null) node = node.left;
            return node;
        }
    }

    private RBNode<T> getMax(RBNode<T> node) {
        if (node == null) {
            return null;
        } else {
            while (node.right != null) node = node.right;
            return node;
        }
    }

    public RBNode<T> successor(RBNode<T> node) {
        //寻找后继节点，也就是比node大的最小节点
        //若有右子节点，则为右子节点
        //否则，若node无父节点，则后继为null，若node是个左子节点，就是其父节点；是个右子节点，则一直向上找到是左分叉的那个父节点。
        if (node.right != null) {
            return getMin(node.right);
        } else {
            if (node.father.left == node) {
                return node.father;
            } else {
                RBNode<T> father = node.father;
                while (father != null && node == father.right) {
                    node = father;
                    father = father.father;
                }
                return father;
            }
        }
    }

    public RBNode<T> predecessor(RBNode<T> node) {
        if (node.left != null) {
            return getMax(node.left);
        }
        RBNode<T> father = node.father;
        while (father != null && node == father.left) {
            node = father;
            father = father.father;
        }
        return father;
    }

    /*
     * 左旋示意图(对节点x进行左旋)：
     *      px                             px
     *     /                              /
     *    x                              y
     *   / \      --(左旋)--            / \
     *  lx  y                          x   ry
     *     / \                        / \
     *    ly  ry                    lx  ly
     */
    private void leftRotate(RBNode<T> x) {
        //1.x的父亲的儿子变成y
        RBNode<T> y = x.right;
        if (x.father == null) root = y;
        else {
            if (x == x.father.left) x.father.left = y;
            else x.father.right = y;
        }
        y.father = x.father;
        //2.x的右子节点=y的左子节点，y的左子节点=x
        x.right = y.left;
        if (x.right != null) x.right.father = x;
        y.left = x;
        x.father = y;
    }

    /*
     * 右旋示意图(对节点y进行左旋)：
     *            py                             py
     *           /                              /
     *          y                              x
     *         / \      --(右旋)--            / \
     *        x  ry                          lx  y
     *       / \                                / \
     *      lx  rx                             rx  ry
     */
    private void rightRotate(RBNode<T> y) {
        //y的父节点的子节点变成x
        RBNode<T> x = y.left;
        if (y.father == null) root = x;
        else {
            if (y == y.father.left) y.father.left = x;
            else y.father.right = x;
        }
        x.father = y.father;
        //y的左子节点=x的右子节点,x的右子节点=y
        y.left = x.left;
        if (y.left != null) y.left.father = y;
        x.right = y;
        y.father = x;
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> father, grandfather;
        //当父节点存在，且父节点是红色的
        while (node.father != null && isRed(node.father)) {
            father = node.father;
            grandfather = father.father;
            //如果父节点是左子节点
            if (grandfather != null && father == grandfather.left) {
                RBNode<T> uncle = grandfather.right;
                //1.叔叔节点是红色的
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(father);
                    setRed(grandfather);
                    node = grandfather;
                    continue;
                }
                //2.叔叔节点是黑色的，且当前节点是右子节点,就转变成3（当前节点是左孩子）
                if (node == father.right) {
                    RBNode<T> tmp = father;
                    leftRotate(father);
                    father = node;
                    node = tmp;
                }
                //3.叔叔节点是黑色的，且当前节点是左子节点
                setBlack(father);
                setRed(grandfather);
                rightRotate(grandfather);
            } else if (grandfather != null && father == grandfather.right) {
                //若父节点是右子节点
                RBNode<T> uncle = grandfather.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(father);
                    setRed(grandfather);
                    node = grandfather;
                    continue;
                }
                //2.叔叔节点是黑色的，且当前节点是左子节点,就转变成3（当前节点是右孩子）
                if (node == father.left) {
                    RBNode<T> tmp = father;
                    rightRotate(father);
                    father = node;
                    node = tmp;
                }
                //3.叔叔节点是黑色的，且当前节点是右子节点
                setBlack(father);
                setRed(grandfather);
                leftRotate(grandfather);
            }
        }
        setBlack(root);
    }

    private void insert(RBNode<T> node) {
        int cmp;
        RBNode<T> y = null;
        RBNode<T> x = root;
        while (x != null) {
            y = x;
            cmp = node.data.compareTo(x.data);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }
        node.father = y;
        if (y != null) {
            cmp = node.data.compareTo(y.data);
            if (cmp < 0)
                y.left = node;
            else
                y.right = node;
        } else {
            root = node;
        }
        setRed(node);
        insertFixUp(node);
    }

    public void insert(T data) {
        RBNode<T> node = new RBNode<T>(data, BLACK, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    private void removeFixUp(RBNode<T> node, RBNode<T> father) {
        RBNode<T> brother;
        while (isBlack(node)&&node!=root){//node是黑色的并且不是根节点
            if(node==father.left){//node是左子节点
                brother=father.right;
                if(isRed(brother)){//1.兄弟是红色的
                    setBlack(brother);
                    setRed(father);
                    leftRotate(father);
                    brother=father.right;
                }
                if(isBlack(brother.left)&&isBlack(brother.right)){
                    //2.兄弟及兄弟的子节点均为黑色
                    setRed(brother);
                    node=father;
                    father=node.father;
                }
                else{
                    if(isBlack(brother.right)){
                        //3.兄弟的右孩子是黑色，左孩子是红色
                        setBlack(brother.left);
                        setRed(brother);
                        rightRotate(brother);
                        brother=father.right;
                    }
                    //4.兄弟节点为黑色，兄弟的右孩子是红色
                    brother.color=father.color;
                    setBlack(father);
                    setBlack(brother.right);
                    leftRotate(father);
                    node=root;
                    break;
                }
            }
            else{
                brother=father.left;
                if(isRed(brother)){//1.兄弟是红色的
                    setBlack(brother);
                    setRed(father);
                    rightRotate(father);
                    brother=father.left;
                }
                if(isBlack(brother.right)&&isBlack(brother.left)){
                    //2.兄弟及兄弟的子节点均为黑色
                    setRed(brother);
                    node=father;
                    father=node.father;
                }
                else{
                    if(isBlack(brother.left)){
                        //3.兄弟的左孩子是黑色，右孩子是红色
                        setBlack(brother.right);
                        setRed(brother);
                        leftRotate(brother);
                        brother=father.left;
                    }
                    //4.兄弟节点为黑色，兄弟的左孩子是红色
                    brother.color=father.color;
                    setBlack(father);
                    setBlack(brother.left);
                    rightRotate(father);
                    node=root;
                    break;
                }
            }
        }
        if (node!=null)
            setBlack(node);
    }

    private void remove(RBNode<T> node) {
        RBNode<T> child, father;
        boolean color;
        if ((node.left != null) && (node.right != null)) {
            RBNode<T> replace = node;
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;
            if (node.father != null) {
                if (node.father.left == node)
                    node.father.left = replace;
                else
                    node.father.right = replace;
            } else {
                root = replace;
            }
            child = replace.right;
            father = replace.father;
            color = colorOf(replace);
            if (father == node) {
                father = replace;
            } else {
                if (child != null)
                    child.father = father;
                father.left = child;

                replace.right = node.right;
                node.right.father = replace;
            }

            replace.father = node.father;
            replace.color = node.color;
            replace.left = node.left;
            node.left.father = replace;

            if (color == BLACK)
                removeFixUp(child, father);
            node = null;
            return;
        }
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        father = node.father;
        color = node.color;

        if (child != null)
            child.father = father;
        if (father != null) {
            if (father.left == node)
                father.left = child;
            else
                father.right = child;
        } else {
            root = child;
        }

        if (color == BLACK)
            removeFixUp(child, father);
        node = null;
    }

    public void remove(T data) {
        RBNode<T> node;
        if ((node = find(data)) != null)
            remove(node);
    }

    public RBNode find(T t) {
        return find(t, root);
    }

    private RBNode find(T t, RBNode<T> node) {
        if (node == null) return null;
        int result = t.compareTo(node.data);
        if (result == 0) return node;
        else if (result > 0) return find(t, node.right);
        else return find(t, node.left);
    }
}
