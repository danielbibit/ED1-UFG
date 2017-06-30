package Exercises;

import Trees.SimpleBST;

public class TreeTest {
    public static void main(String[] args){
        SimpleBST<Integer> tree = new SimpleBST();
        
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(1);
        //tree.add(5);
        
        System.out.println(tree.floor());
        System.out.println(tree.ceil());
        
        tree.add(10);
        
        System.out.println(tree.floor());
        System.out.println(tree.ceil());
        tree.search(6);
        System.out.println(tree.contains(7));
    }
}
