public class RBTree {
    private final int R=0;
    private final int B=1;
    private Node root=null;

    class Node{
        int data; //存的具体数字
        int color=R;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }
    //插入红黑树
     public void insert(Node root, int data){//root节点不为空
        //判断
         if (root.data<data){
             if(root.right == null){
                 root.right = new Node(data);
             }else{
                 insert(root.right,data);
             }
         }else {
             if(root.left==null){
                 root.left = new Node(data);
             }else{
                 insert(root.left,data);
             }
         }
     }
     //左旋
    public void leftRotate(Node node) {
        //判断是不是根节点
        if (node.parent == null) {
            Node E = root;
            Node S = E.right;
            //移右子树
            E.right = S.left;
            S.left.parent=E;
            E.parent = S;
            S.left =null;
        }else{
            if(node == node.parent.left){
                node.parent.left = node.right;
            }else{
                node.parent.right = node.right;
            }
            node.right = node.right.left;
            node.right.left.parent=node;
            node.parent.left=node;
        }
    }

    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        Node root = rbTree.initRoot(12);
        rbTree.insert(root,12);
    }

    private Node initRoot(int i) {
        return null;
    }
}
