package Trees;

public class SimpleBST<E extends Comparable<E>> {
    
    private Node<E> root = null;
    
    public E search(E e) {
        return this.search(this.root, e).element;
    }
    
    private Node<E> search(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        
        if (node.element.compareTo(e) == 0) {
            return node;
        } else if (e.compareTo(node.element) < 0) {
            return this.search(node.leftChildren, e);
        } else {
            return this.search(node.rightChildren, e);
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
    
    public E remove(E e){
        Node<E> node = this.search(this.root, e);
        E element = node.element;
        
        if(node.leftChildren == null && node.rightChildren == null){
            node.element = null;
            
            if(node.parent.leftChildren == node){
                node.parent.leftChildren = null;
            }else{
                node.parent.rightChildren = null;
            }
        }else if(node.leftChildren == null || node.rightChildren == null){
            node.element = null;
            
            Node<E> children;
            
            if(node.leftChildren == null){
                children = node.rightChildren;
            }else{
                children = node.leftChildren;
            }
            
            if(node.parent.leftChildren == node){
                node.parent.leftChildren = children;
            }else{
                node.parent.rightChildren = children;
            }
        }else{
            Node<E> sucessor;// = this.remove(this.sucessor(node));
//            node.element = sucessor.element;
        }
         
        return element;
    }
    
    public E minimum() {
        return this.subTreeMinimum(this.root).element;
    }
    
    private Node<E> subTreeMinimum(Node<E> node) {
        while (node.leftChildren != null) {
            node = node.leftChildren;
        }
        
        return node;
    }
    
    public E maximum() {
        return this.subTreeMaximum(this.root).element;
    }
    
    private Node<E> subTreeMaximum(Node<E> node) {
        while (node.rightChildren != null) {
            node = node.rightChildren;
        }
        
        return node;
    }
    
    public E sucessor(E e) {
        //return (E) this.subTreeMinimum(node.rightChildren).element;
        return null;
    }
    
    private Node<E> sucessor(Node<E> node){
        return this.subTreeMinimum(node.rightChildren);
    }
    
    public E predecessor(Node<E> node) {
        return (E) this.subTreeMaximum(node.leftChildren).element;
    }
    
    private int height(Node<E> node) {
        return node == null ? -1 : 1 + Math.max(height(node.leftChildren), height(node.rightChildren));
    }
    
    public int treeHeight() {
        return height(this.root);
    }
    
    private int balance(Node<E> node) {
        return this.height(node.leftChildren) - this.height(node.rightChildren);
    }
    
    public boolean isAvl() {
        return this.isAvl(this.root);
    }
    
    private boolean isAvl(Node<E> node) {
        if (node == null) 
            return true;
        
        if (this.balance(node) > 1 || this.balance(node) < -1)
            return false;
        else 
            return isAvl(node.leftChildren) && isAvl(node.rightChildren);
    }
    
    @Override
    public String toString() {
        return "";
    }
}
