package datastruct.tree;

public class AVLTree {


    /**
     * LL型旋转方法，输入参数为失衡节点
     *
     * @param node
     */
    public void LLRotate(AVLNode node) {
        AVLNode parent = node.parent;
        AVLNode leftChild = node.leftChild;
        //如果失衡节点的右孩子不为空
        if (leftChild.rightChild != null) {
            leftChild.rightChild.parent = node;
        }
        node.leftChild = leftChild.rightChild;
        //建立失衡节点左孩子与失衡节点父节点之间的联系
        leftChild.rightChild = node;
        leftChild.parent = parent;

        if (parent != null) {
            if (node == parent.leftChild) {
                parent.leftChild = leftChild;
            } else {
                parent.rightChild = leftChild;
            }
        }
        node.parent = leftChild;

    }

    public void RRRotate(AVLNode node) {
        AVLNode parent = node.parent;
        AVLNode rightChild = node.rightChild;
        if (rightChild.leftChild != null) {
            rightChild.leftChild.parent = node;
        }
        node.rightChild = rightChild.leftChild;

        rightChild.parent = parent;
        rightChild.leftChild = node;
        if (parent != null) {
            if (parent.leftChild == node) {
                parent.leftChild = rightChild;
            } else {
                parent.rightChild = rightChild;
            }
        }
        node.parent = rightChild;
    }

    public void LRRotate(AVLNode node) {
        LLRotate(node.leftChild);
        RRRotate(node);
    }

    public void RLRotate(AVLNode node) {
        RRRotate(node.rightChild);
        LLRotate(node);
    }

    public static class AVLNode {

        int depth;
        int value;
        AVLNode leftChild;
        AVLNode rightChild;
        AVLNode parent;
    }
}
