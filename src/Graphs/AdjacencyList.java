package Graphs;

import java.util.ArrayList;

public class AdjacencyList<E> {
    private final ArrayList<E> vertexList = new ArrayList();
    private final ArrayList<ArrayList<E>> adjacency = new ArrayList();
    
    public void addVertex(E e){
        vertexList.add(e);
    }
    
    public void removeVertex(E e){
        vertexList.remove(e);
        
        adjacency.remove(vertexList.indexOf(e));
        
        for(ArrayList<E> l : adjacency){
            l.remove(e);
        }
    }
    
    public boolean isAdjacent(E e1, E e2){
        if(!vertexList.contains(e1) && !vertexList.contains(e2)){
            return false;
        }
        
        return adjacency.get(vertexList.indexOf(e1)).contains(e2);
    }
    
    public ArrayList<E> neighbourHood(E e){
        if(!vertexList.contains(e)){
            return null;
        }
        return adjacency.get(vertexList.indexOf(e));
    }
    
    public void insertEdge(E e1, E e2){
        adjacency.get(vertexList.indexOf(e1)).add(e2);
    }
}
