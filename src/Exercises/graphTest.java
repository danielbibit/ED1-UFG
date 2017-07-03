package Exercises;

import Graphs.AdjacencyList;
import Graphs.Vertex;

public class graphTest {
    public static void main(String[] args){
        AdjacencyList graph = new AdjacencyList();
        
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        //graph.insertEdge(1, 2);
    }
}
