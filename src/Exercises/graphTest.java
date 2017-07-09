package Exercises;

import Graphs.AdjacencyList;
import Graphs.Vertex;

public class graphTest {
    public static void main(String[] args){
        AdjacencyList<Integer> graph = new AdjacencyList();
        
        graph.addVertex(1);
        graph.addVertex(2);
        graph.insertEdge(1, 2);
    }
}
