package DataStructures;

public class binarySearchTree<T extends Comparable<T>> {
    protected class Node implements Comparable<Node> {
        T data;
        Node left;
        Node right;

        Node(T element) {
            data = element;
            left = null;
            right = null;
        }

        public int compareTo(Node o) {
            return data.compareTo(o.data);
        }
    }

    public Node root;


    public binarySearchTree() {
        root = null;
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private Node insert(Node node, T element) {
        if (node == null) {
            return new Node(element);
        }
        if (element.compareTo(node.data) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = insert(node.right, element);
        }
        return node;
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }


    public boolean find(Node node, T element) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(element) == 0) return true;
        if (element.compareTo(node.data) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = insert(node.right, element);
        }
        return false;
    }

}
