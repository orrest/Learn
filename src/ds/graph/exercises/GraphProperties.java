package ds.graph.exercises;

import ds.graph.Graph;
import edu.princeton.cs.algs4.In;

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
            e[v] = bfs(G, v);
        }
    }

    /**
     * 找到一个顶点的离心率
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
        return eccentricityOfVertex(distTo, Math::max);
    }

    /**
     * 离心率为离这个顶点最远的顶点的最短距离
     * @param distTo 一个顶点与其它顶点的最短路径
     * @return 离心率
     */
    private int eccentricityOfVertex(int[] distTo, ICompareFunc icf){
        int res = Integer.MIN_VALUE;
        for (int t : distTo) {
            res = icf.compare(t, res);
        }
        return res;
    }

    /**
     * 离心率，找到顶点v和其他顶点间最短路径里面最大的
     * @param v 顶点
     * @return 离心率
     */
    public int eccentricity(int v){
        return e[v];
    }

    /**
     * @return 所有顶点中最大的离心率
     */
    public int diameter(){
        return eccentricityOfVertex(e, Math::max);
    }

    /**
     * @return 所有顶点中最小的离心率
     */
    public int radius(){
        return eccentricityOfVertex(e, Math::min);
    }

    /**
     * @return 离心率和半径相等的顶点为图的中点
     */
    public int center(){
        return 0;
    }

    interface ICompareFunc{
        /**
         * @param a 一个数字
         * @param b 另一个数字
         * @return 返回比较后得到的数字
         */
        int compare(int a, int b);
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        GraphProperties p = new GraphProperties(G);

        System.out.println("离心率");
        System.out.println(p.eccentricity(0));
        System.out.println("直径");
        System.out.println(p.diameter());
        System.out.println("半径");
        System.out.println(p.radius());
        System.out.println("中点");
        System.out.println(p.center());
    }
}

