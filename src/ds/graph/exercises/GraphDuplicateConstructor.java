package ds.graph.exercises;

import ds.graph.Graph;
import edu.princeton.cs.algs4.Bag;

public class GraphDuplicateConstructor {
    private final Bag<Integer>[] adj;
    private final int V;
    private final int E;

    public GraphDuplicateConstructor(Graph G){
        V = G.V();
        E = G.E();
        adj = new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();

        // copy the graph
        // 注意: 不能使用addEdge, 因为给的就是个图, 而不是顶点对儿.
        for (int i = 0; i < G.V(); i++){
            for (int v : G.adj(i)){
                adj[i].add(v);
            }
        }
    }

    public int E(){ return E; }
    public int V(){ return V; }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 3);
        G.addEdge(2, 3);
        for (int i = 0; i < G.V(); i++){
            System.out.print(i +": ");
            for (int v : G.adj(i))
                System.out.print(v + "   ");
            System.out.println();
        }
        System.out.println("----------------");
        GraphDuplicateConstructor gd = new GraphDuplicateConstructor(G);
        for (int i = 0; i < gd.V(); i++){
            System.out.print(i +": ");
            for (int v : gd.adj(i))
                System.out.print(v + "   ");
            System.out.println();
        }
    }
}
