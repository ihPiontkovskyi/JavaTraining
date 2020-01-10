package ua.epam.training.piontkovskyi.task5_4;

public class RBTree<T extends Comparable<T>> {

    enum Color {RED, BLACK}

    private class Node {
        private T key;
        private Node parent;
        private Node left;
        private Node right;
        private Color color;

        Node() {
            color = Color.BLACK;
            parent = null;
            left = null;
            right = null;
        }

        Node(T key) {
            this();
            this.key = key;
        }

        private StringBuilder buildTree(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if (right != nil) {
                right.buildTree(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(color).append("(").append(key.toString()).append(")").append("\n");
            if (left != nil) {
                left.buildTree(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        @Override
        public String toString() {
            return this.buildTree(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }

    private Node nil = new Node();
    private Node root = nil;

    public RBTree() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }

    private void leftRotate(Node node) {
        Node tmp;
        tmp = node.right;
        node.right = tmp.left;
        if (!isNil(tmp.left)) {
            tmp.left.parent = node;
        }
        tmp.parent = node.parent;
        if (isNil(node.parent)) {
            root = tmp;
        } else if (node.parent.left == node) {
            node.parent.left = tmp;
        } else {
            node.parent.right = tmp;
        }
        tmp.left = node;
        node.parent = tmp;
    }

    private void rightRotate(Node node) {
        Node tmp = node.left;
        node.left = tmp.right;
        if (!isNil(tmp.right)) {
            tmp.right.parent = node;
        }
        tmp.parent = node.parent;
        if (isNil(node.parent)) {
            root = tmp;
        } else if (node.parent.right == node) {
            node.parent.right = tmp;
        } else {
            node.parent.left = tmp;
        }
        tmp.right = node;
        node.parent = tmp;
    }

    public void insert(T key) {
        insert(new Node(key));
    }

    private void insert(Node node) {
        Node tmp = nil;
        Node search = root;
        while (!isNil(search)) {
            tmp = search;
            if (node.key.compareTo(search.key) < 0) {
                search = search.left;
            } else {
                search = search.right;
            }
        }
        node.parent = tmp;
        if (isNil(tmp)) {
            root = node;
        } else if (node.key.compareTo(tmp.key) < 0) {
            tmp.left = node;
        } else {
            tmp.right = node;
        }
        node.left = nil;
        node.right = nil;
        node.color = Color.RED;
        insertFixup(node);
    }

    private void insertFixup(Node node) {
        Node tmp;
        while (node.parent.color.equals(Color.RED)) {
            if (node.parent == node.parent.parent.left) {
                tmp = node.parent.parent.right;
                if (tmp.color.equals(Color.RED)) {
                    node.parent.color = Color.BLACK;
                    tmp.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else if (node == node.parent.right) {
                    node = node.parent;
                    leftRotate(node);
                } else {
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                tmp = node.parent.parent.left;
                if (tmp.color.equals(Color.RED)) {
                    node.parent.color = Color.BLACK;
                    tmp.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else if (node == node.parent.left) {
                    node = node.parent;
                    rightRotate(node);
                } else {
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private boolean isNil(Node node) {
        return node == nil;
    }

    @Override
    public String toString() {
        return "RedBlackTree:\n" + root;
    }

}