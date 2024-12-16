package DataStructures;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import java.util.ArrayList;


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
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public T getRoot() {return root.data;}

    public boolean find(T element) {return find(root, element);}

    private boolean find(Node node, T element) {
        if (node == null) {
            return false;
        }
        if (element.compareTo(node.data) < 0) {
            find(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            find(node.right, element);
        } else if (element.compareTo(node.data) == 0) return true;
        return false;
    }

    public void nlr(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        nlr(node.left);
        nlr(node.right);
    }

    public void lrn(Node node) {
        if (node == null) return;
        lrn(node.left);
        lrn(node.right);
        System.out.print(node.data + " ");
    }

    public double ave() {
        return (double)total(root) / count(root);
    }

    private int count(Node node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }

    public int total(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return (Integer) node.data + total(node.right);
        }
        if (node.right == null) {
            return (Integer) node.data + total(node.left);
        }
        return (Integer) node.data + total(node.left) + total(node.right);
    }

    public void invert() { root = invert(root); }
    public int height() { return height(root); }
    public int width() { return width(root); }

    private Node invert(Node node) {
        if (node == null) return null;
        Node left = invert(node.left);
        node.left = invert(node.right);
        node.right = left;
        return node;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int width(Node node) {
        if (node == null) return 0;
        Queue<Node> que = new Queue<>();
        que.enqueue(node);
        int max = 0;
        while (!que.isEmpty()) {
            int count = que.size;
            max = Math.max(max, count);
            while (count --> 0) {
                Node current = que.dequeue();
                if (current.left != null) que.enqueue(current.left);
                if (current.right != null) que.enqueue(current.right);
            }
        }
        return max;
    }

    public T removeclose(T element) {
        return removeclose(root, element);
    }

    private T removeclose(Node node, T element) {
        if (node == null) return null;
        if (node.data.compareTo(element) == 0) {
            var t = node.data;
            delete(node.data);

            return t;

        } else if (node.left != null && node.right != null) {
            if (element.compareTo(node.left.data) > 0 && element.compareTo(node.data) < 0) {
                var t = node.data;
                delete(node.data);
                return t;
            } else if (element.compareTo(node.right.data) < 0 && element.compareTo(node.data) > 0) {
                var t = node.data;
                delete(node.data);
                return t;
            } else {
                removeclose(node.left, element);
                removeclose(node.right, element);
            }
        } else if (node.left != null) {
            if (element.compareTo(node.left.data) > 0 && element.compareTo(node.data) < 0) {
                var t = node.data;
                delete(node.data);
                return t;
            } else {
                removeclose(node.left, element);
            }
        } else if (node.right != null) {
            if (element.compareTo(node.right.data) < 0 && element.compareTo(node.data) > 0) {
                var t = node.data;
                delete(node.data);
                return t;
            } else {
                removeclose(node.right, element);
            }
        }
        return node.data;
    }

    public T findclose(Integer num) {
        var node = root;
        var close = Math.abs((Integer)node.data-num);
        Queue<Node> que = new Queue<>();
        que.enqueue(node);
        while (!que.isEmpty()) {
            int count = que.size;
            while (count --> 0) {
                Node current = que.dequeue();
                if (Math.abs((Integer) current.data-num) < close) {
                    close = Math.abs((Integer)current.data - num);
                    node = current;
                }
                if (current.left != null) que.enqueue(current.left);
                if (current.right != null) que.enqueue(current.right);
            }
        }
        return node.data;
    }

    public void bread() {
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.data + " ");
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
        System.out.println();
    }

    public void depthfs() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        System.out.println();
    }

}
