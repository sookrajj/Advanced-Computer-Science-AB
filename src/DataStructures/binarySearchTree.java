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

    public void delete(T element) {
        root = delete(root, element);
    }

    private Node delete(Node node, T element) {
        if (node == null) return null;
        if (element.compareTo(node.data) < 0) node.left = delete(node.left, element);
        else if (element.compareTo(node.data) > 0) node.right = delete(node.right, element);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }


        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
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

    public T getRoot() {return root.data;}

    public boolean find(T element) {return find(root, element);}

    private boolean find(Node node, T element) {
        if (node == null) {
            return false;
        }
        if (element.compareTo(node.data) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            node.right = insert(node.right, element);
        }
        return false;
    }

    public void nlr(Node node) {
        if (node == null) return;
        System.out.println(node.data + " ");
        inOrder(node.left);
        inOrder(node.right);
    }

    public void lrn(Node node) {
        if (node == null) return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.data + " ");
    }

    public int total(Node node, int element) {
        if (node == null) {
            return element;
        }
        if (node.left == null) return total(node.right, element+(int)node.data);
        if (node.right == null) return total(node.left, element+(int)node.data);
        return total(node.left, element+(int)node.data) + total(node.right, element+(int)node.data);
    }


}
