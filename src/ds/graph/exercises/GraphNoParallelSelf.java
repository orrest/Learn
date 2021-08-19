package ds.graph.exercises;

import ds.graph.Graph;
import edu.princeton.cs.algs4.In;

/**
 * 实现不能增加平行边和自环的图，并测试。
 */
public class GraphNoParallelSelf extends Graph {
    public GraphNoParallelSelf(int V) {
        super(V);
    }

    public GraphNoParallelSelf(In in) {
        super(in);
    }

    @Override
    public void addEdge(int v, int w) {
        if (v == w)
            throw new RuntimeException("Self cycle NOT allowed."); // 自环
        if (hasEdge(v, w))
            throw new RuntimeException("Parallel edge NOT allowed."); // 平行边

        super.addEdge(v, w);
    }

    public static void main(String[] args) {
        Graph G = new GraphNoParallelSelf(3);
        try{
//            G.addEdge(0, 0);
            G.addEdge(0, 1);
            G.addEdge(1, 0);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
