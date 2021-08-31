package ds.graph.exercises;

import ds.graph.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class GraphProperties {
    private final boolean[] marked;
    private final int[] distTo;   // 记录每个顶点到其它顶点的最短路径，其中最大的为离心率
    private final int[] e;    // 记录所有顶点的离心率

    public GraphProperties(Graph G){
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        e = new int[G.V()];
        allBfs(G);
    }

    /**
     * 找到所有顶点的离心率
     * @param G 一副图
     */
    private void allBfs(Graph G){
        for (int v = 0; v < G.V(); v++){
            Arrays.fill(distTo, 0);
            Arrays.fill(marked, false); // 忘记把marked重置了!
            e[v] = bfs(G, v);
        }
    }

    /**
     * 离心率，找到顶点v和其他顶点间最短路径里面最大的
     * @param G 一副图
     * @param v 一个顶点
     * @return 一个顶点的离心率
     */
    private int bfs(Graph G, int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        marked[v] = true;
        while (!queue.isEmpty()){
            int w = queue.poll();
            for (int u: G.adj(w)){
                if (!marked[u]){
                    queue.offer(u);
                    marked[u] = true;
                    distTo[u] = distTo[w]+1;
                }
            }
        }
        return distTo[findMaxIndexInArray(distTo)];
    }

    private int findMaxIndexInArray(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            index = arr[i] > arr[index] ? i : index;
        }
        return index;
    }

    private int findMinIndexInArray(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            index = arr[i] < arr[index] ? i : index;
        }
        return index;
    }

    /**
     * @param v 顶点
     * @return 离心率
     */
    public int eccentricity(int v){
        return e[v];
    }

    /**
     * @return 直径, 所有顶点中最大的离心率
     */
    public int diameter(){
        return e[findMaxIndexInArray(e)];
    }

    /**
     * @return 半径, 所有顶点中最小的离心率
     */
    public int radius(){
        return e[findMinIndexInArray(e)];
    }

    /**
     * @return 一个顶点, 它的离心率和半径相等
     */
    public int center(){
        return findMinIndexInArray(e);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(0 ,1);
        graph.addEdge(1 ,2);
        graph.addEdge(2 ,3);
        graph.addEdge(3 ,4);
        graph.addEdge(4 ,5);
        graph.addEdge(5 ,6);
        graph.addEdge(6 ,7);
        graph.addEdge(7 ,8);
        graph.addEdge(8 ,9);
        graph.addEdge(9 ,10);

        GraphProperties graphProperties = new GraphProperties(graph);
        StdOut.println("Diameter: " + graphProperties.diameter() + " Expected: 10");
        StdOut.println("Radius: " + graphProperties.radius() + " Expected: 5");
        StdOut.println("Center: " + graphProperties.center() + " Expected: 5");

        for (int i = 0; i < graphProperties.e.length; i++){
            System.out.println(i+" "+graphProperties.e[i]);
        }
    }
}

