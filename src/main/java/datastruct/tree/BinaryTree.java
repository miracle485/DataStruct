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
        if (delNode == null) {
            return root;
        }

        if (delNode.left == null) {
            TreeNode result = deleteSingleNode(delNode, parent, delNode.right);
            if (parent == null) {
                root = result;
            }
        } else if (delNode.right == null) {
            TreeNode result = deleteSingleNode(delNode, parent, delNode.right);
            if (parent == null) {
                root = result;
            }
        } else {
            TreeNode left = delNode.right;
            TreeNode rParent = delNode;
            while (left.left != null) {
                rParent = left;
                left = left.left;
            }
            delNode.val = left.val;
            if (rParent.left == left) {
                rParent.left = left.right;
            } else {
                rParent.right = left.right;
            }
        }

        return root;
    }

    public TreeNode deleteSingleNode(TreeNode del, TreeNode parent, TreeNode dist) {
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
