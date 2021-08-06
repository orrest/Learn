package ds.graph;

import edu.princeton.cs.algs4.In;

public class GraphTest2 {
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        System.out.println("------------------");
        for(int i = 0; i < g.V(); i++){
            System.out.print(i+": ");
            for(Integer a : g.adj(i)){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
