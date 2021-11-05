package pers.xf.learn.datastructure.graph;

import edu.princeton.cs.algs4.In;

public class GraphTest1 {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int V = in.readInt();
        int E = in.readInt();
        Graph g = new Graph(V);
        for(int i = 0; i < E; i ++){
            g.addEdge(in.readInt(), in.readInt());
        }
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
