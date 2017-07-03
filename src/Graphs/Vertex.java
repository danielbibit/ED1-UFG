package Graphs;

import java.util.ArrayList;

public class Vertex<E> {
    ArrayList<Edge> neighbourHood;
    E element;
    int degree;
    
    public Vertex(E e){
        this.element = e;
    }
}
