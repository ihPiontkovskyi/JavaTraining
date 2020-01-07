package ua.epam.training.piontkovskyi.task5_4;

public class RBTree<T extends Comparable<T>> {
    enum Color {RED, BLACK}

    private class Node {
        private T key;
        private Node parent;
        private Node left;
        private Node right;
        private int numLeft;
        private int numRight;
        private Color color;

        Node() {
            color = Color.BLACK;
            numLeft = 0;
            numRight = 0;
            parent = null;
            left = null;
            right = null;
        }

        Node(T key) {
            this();
            this.key = key;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if (right != nil) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(color).append("(").append(key.toString()).append(")").append("\n");
            if (left != nil) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        @Override
        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
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
        leftRotateFixup(node);
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

    private void leftRotateFixup(Node node) {
        if (isNil(node.left) && isNil(node.right.left)) {
            node.numLeft = 0;
            node.numRight = 0;
            node.right.numLeft = 1;
        } else if (isNil(node.left) && !isNil(node.right.left)) {
            node.numLeft = 0;
            node.numRight = 1 + node.right.left.numLeft +
                    node.right.left.numRight;
            node.right.numLeft = 2 + node.right.left.numLeft +
                    node.right.left.numRight;
        } else if (!isNil(node.left) && isNil(node.right.left)) {
            node.numRight = 0;
            node.right.numLeft = 2 + node.left.numLeft + node.left.numRight;
        } else {
            node.numRight = 1 + node.right.left.numLeft +
                    node.right.left.numRight;
            node.right.numLeft = 3 + node.left.numLeft + node.left.numRight +
                    node.right.left.numLeft + node.right.left.numRight;
        }
    }

    private void rightRotate(Node node) {
        rightRotateFixup(node);
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

    private void rightRotateFixup(Node node) {
        if (isNil(node.right) && isNil(node.left.right)) {
            node.numRight = 0;
            node.numLeft = 0;
            node.left.numRight = 1;
        } else if (isNil(node.right) && !isNil(node.left.right)) {
            node.numRight = 0;
            node.numLeft = 1 + node.left.right.numRight +
                    node.left.right.numLeft;
            node.left.numRight = 2 + node.left.right.numRight +
                    node.left.right.numLeft;
        } else if (!isNil(node.right) && isNil(node.left.right)) {
            node.numLeft = 0;
            node.left.numRight = 2 + node.right.numRight + node.right.numLeft;
        } else {
            node.numLeft = 1 + node.left.right.numRight +
                    node.left.right.numLeft;
            node.left.numRight = 3 + node.right.numRight +
                    node.right.numLeft +
                    node.left.right.numRight + node.left.right.numLeft;
        }

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
                search.numLeft++;
                search = search.left;
            } else {
                search.numRight++;
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