package ds.graph.exercises;

import ds.graph.Graph;

import java.util.ArrayList;

/** 4.1.10
 * 证明在任意一副连通图中都存在一个顶点，删去它（以及它所相连的所有边）不会影响到图的连通性。
 * 编写一个DFS方法找出这样一个顶点。提示：留心那些相邻顶点全都被标记过的顶点。
 *     0-1
 *     \/
 *     2
 *    /\
 *   3 4
 * 理论上0, 1, 3, 4被删掉都不会影响上图连通性，但如果从0开始遍历，按此类实现的算法0不会被标记为可删除，
 * 因为当0开始遍历时它的邻居都没被遍历过。
 */
public class GraphDeleteVertexReserveConnectivity {
    private final boolean[] marked;
    private final ArrayList<Integer> deleteVertex;

    public GraphDeleteVertexReserveConnectivity(Graph G){
        this.marked = new boolean[G.V()];
        this.deleteVertex = new ArrayList<>();
        dfs(G, 1);
    }

    private void dfs(Graph G, int v){
        boolean allAdjVisited = true;
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                allAdjVisited = false;
                dfs(G, w);
            }
        }

        if (allAdjVisited) this.deleteVertex.add(v);
    }

    public Iterable<Integer> findVertexCanBeDelete(){
        return this.deleteVertex;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        GraphDeleteVertexReserveConnectivity g =
                new GraphDeleteVertexReserveConnectivity(graph);

        for (int i : g.findVertexCanBeDelete()){
            System.out.println(i);
        }
    }
}
