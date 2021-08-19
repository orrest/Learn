package ds.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int vertex;
    private int edge;
    private Bag<Integer>[] adj;


    /**
     * Initialize ds.graph with vertexes only.
     * @param V vertex num
     */
    @SuppressWarnings("unchecked")
    public Graph(int V){
        this.vertex = V;
        this.edge = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < this.adj.length; i++){
            this.adj[i] = new Bag<>();
        }
    }

    /**
     * Read vertex_num, edge_num, edges from the input stream.
     * Initialize the ds.graph vertexes and add edges to it.
     * @param in the input stream
     */
    public Graph(In in){
        this(in.readInt());
        int e = in.readInt();
        for(int i = 0; i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V(){return this.vertex;}

    public int E(){return this.edge;}

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        this.edge ++;
    }

    public boolean hasEdge(int v, int w){
        for (int a : adj[v])
            if (a == w) return true;

        return false;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    protected Bag<Integer>[] getGraphDataStructure(){ return adj; }
}
