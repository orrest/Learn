package pers.xf.learn.datastructure.graph.exercises;

import pers.xf.learn.datastructure.graph.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

public class GraphHasEdge extends Graph {
    public GraphHasEdge(int V) {
        super(V);
    }

    public GraphHasEdge(In in) {
        super(in);
    }

    public boolean hasEdge(int v, int w){
        Bag<Integer>[] adj = getGraphDataStructure();
        for (int a : adj[v]){
            if (a == w) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GraphHasEdge G = new GraphHasEdge(new In(args[0]));

        // print graph
        for (int i = 0; i < G.V(); i++){
            System.out.print(i);
            for (int v : G.adj(i)){
                System.out.print(" " + v);
            }
            System.out.println();
        }

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int v = cin.nextInt();
            int w = cin.nextInt();
            boolean r = G.hasEdge(v, w);
            System.out.println(v + " " + w + " - " + r);
        }
    }
}
