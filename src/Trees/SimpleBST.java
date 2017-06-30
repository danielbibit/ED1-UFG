package Trees;

public class SimpleBST<E extends Comparable<E>> {

    private Node<E> root = null;

    public E search(E e) {
        return this.search(this.root, e);
    }

    private E search(Node<E> node, E e) {
        if (node == null) {
            return null;
        }

        if (node.element.compareTo(e) == 0) {
            return e;
        } else if (e.compareTo(node.element) < 0) {
            return (E) this.search(node.leftChildren, e);
        } else{
            return (E) this.search(node.rightChildren, e);
        }
    }

    public boolean contains(E e) {
        if (this.search(e) == e) {
            return true;
        } else {
            return false;
        }
    }

    public void add(E e) {
        this.root = add(root, null, e);
    }

    private Node<E> add(Node<E> node, Node<E> lastNode, E e) {
        if (node == null) {
            node = new Node();
            node.parent = lastNode;
            node.element = e;
            return node;
        }

        if (node.element.compareTo(e) > 0) {
            node.leftChildren = this.add(node.leftChildren, node, e);
        } else if (node.element.compareTo(e) < 0) {
            node.rightChildren = this.add(node.rightChildren, node, e);
        } else {
            node.element = e;
            node.parent = lastNode;
        }

        return node;
    }

    public E remove(E e) {
        return null;
    }

    private int height(Node<E> node) {
        return node == null ? -1 : 1 + Math.max(height(node.leftChildren), height(node.rightChildren));
    }

    public int treeHeight() {
        return height(this.root);
    }

    public E floor() {
        Node<E> currentNode = this.root;

        while (currentNode.leftChildren != null) {
            currentNode = currentNode.leftChildren;
        }

        return currentNode.element;
    }

    public E ceil() {
        Node<E> currentNode = this.root;
        while (currentNode.rightChildren != null) {
            currentNode = currentNode.rightChildren;
        }

        return currentNode.element;
    }

    @Override
    public String toString() {
        return "";
    }
}
