package Trees;

public class BinarySearchTree<E extends Comparable<E>>{
	private Node<E> root;

	public E search(Node<E> node, E e){
        
        if(node.element.compareTo(e) == 0){
            return e;
        }else if(node.element.compareTo(e) < 0){
            return (E) this.search(node.leftChildren, e);
        }else{
            return (E) this.search(node.rightChildren, e);
        }
	}
	
	public void add(Node<E> node, E e){
        if(node == null){
            //new Node(e);
        }
        
        if(node.element.compareTo(e) < 0){
            //
        }else if(node.element.compareTo(e) > 0){
            //
        }else{
            //
        }
	}

	public E remove(E e){
		return null;
	}
    
    private int height(Node<E> node){
        return node == null ? -1 : 1 + Math.max(height(node.leftChildren), height(node.rightChildren));
    }
    
	public E floor(){
        Node<E> currentNode = root;
        
        while(currentNode != null){
            if(currentNode.leftChildren == null){
                return currentNode.element;
            }
            
            currentNode = currentNode.leftChildren;
        }
        
        return null;
	}

	public E ceil(){
        Node<E> currentNode = root;
        while(currentNode != null){
            currentNode = currentNode.rightChildren;
        }
        
        return (E)currentNode.parent.element;
	}
}
