package Graphs;

import java.util.ArrayList;

public class AdjacencyList {
    private ArrayList<Vertex> vertexList = new ArrayList();
    private ArrayList<ArrayList<Vertex>> adjacency = new ArrayList();
    
    public void addVertex(Vertex v){
        vertexList.add(v);
    }
    
    public void removeVertex(Vertex v){
        vertexList.remove(v);
        
        adjacency.remove(vertexList.indexOf(v));
        
        for(ArrayList<Vertex> l : adjacency){
            l.remove(v);
        }
    }
    
    public boolean isAdjacent(Vertex v1, Vertex v2){
        if(!vertexList.contains(v1) && !vertexList.contains(v2)){
            return false;
        }
        
        return adjacency.get(vertexList.indexOf(v1)).contains(v2);
    }
    
    public ArrayList<Vertex> neighbourHood(Vertex v){
        if(!vertexList.contains(v)){
            return null;
        }
        return adjacency.get(vertexList.indexOf(v));
    }
    
    public void insertEdge(Vertex v1, Vertex v2){
        adjacency.get(vertexList.indexOf(v1)).add(v2);
    }
}
