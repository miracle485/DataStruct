package datastruct.tree;

public class BinaryTree {

    public void insertKey(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key > curr.val) {
                curr = curr.right;
            } else if (key < curr.val) {
                curr = curr.left;
            } else {
                return;
            }
        }
        if (parent == null) {
            if (root.val < key) {
                root.right = new TreeNode(key);
            } else {
                root.left = new TreeNode(key);
            }
        } else {
            if (parent.val < key) {
                parent.right = new TreeNode(key);

            } else {
                parent.right = new TreeNode(key);
            }
        }

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        //寻找待删除的节点
        TreeNode parent = null;
        TreeNode delNode = root;
        while (delNode != null && delNode.val != key) {
            parent = delNode;
            if (key > delNode.val) {
                delNode = delNode.right;
            } else if (key < delNode.val) {
                delNode = delNode.left;
            }
        }
        //如果没找到待删除的节点，直接返回
        if (delNode == null) {
            return root;
        }

        //如果待删除节点的左子树是空的，简化为删除只有右子树的节点的情况
        if (delNode.left == null) {
            TreeNode result = deleteSingleNode(delNode, parent, delNode.right);
            if (parent == null) {
                root = result;
            }
        }//如果待删除节点的右子树是空的，简化为删除只有左子树的节点的情况
        else if (delNode.right == null) {
            TreeNode result = deleteSingleNode(delNode, parent, delNode.right);
            if (parent == null) {
                root = result;
            }
        } //如果待删除节点左右子树都不为空
        else {
            TreeNode left = delNode.right;
            TreeNode rParent = delNode;
            //那么先去寻找待删除节点的后继节点，即右子树的最左节点
            while (left.left != null) {
                rParent = left;
                left = left.left;
            }
            //此时将待删除节点的值替换为后继节点的值
            delNode.val = left.val;
            //用后继节点的右子树替换后继节点的位置
            if (rParent.left == left) {
                rParent.left = left.right;
            } else {
                rParent.right = left.right;
            }
        }

        return root;
    }

    /**
     * 删除只有一颗子树的情况
     *
     * @param del    待删除的节点
     * @param parent 待删除节点的父节点
     * @param dist   待删除节点的左子树或者右子树
     * @return 返回删除后的待删除节点，方便待删除节点为根节点时的情况处理
     */
    public TreeNode deleteSingleNode(TreeNode del, TreeNode parent, TreeNode dist) {
        //如果父节点为空，说明当前节点为子节点
        if (parent == null) {
            del = dist;
        } else if (del == parent.left) {
            parent.left = dist;
        } else {
            parent.right = dist;
        }
        return del;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
