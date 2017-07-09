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
        
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        
        tree.add(10);
//		tree.add(11); //Uncoment to desbalance tree
//		tree.add(12);
        
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        
        System.out.println(tree.remove(4));
        
//        System.out.println(tree.minimum());
//        System.out.println(tree.maximum());
    }
}
