package ds.graph.exercises;

import ds.graph.Graph;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class GraphProperties {
    private final boolean[] marked;
    private final int[] distTo;   // 记录每个顶点到其它顶点的最短路径，其中最大的为离心率
    private final int[] e;    // 记录所有顶点的离心率

    private final int[] edgeTo;
    private int girth;

    public GraphProperties(Graph G){
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        e = new int[G.V()];

        edgeTo = new int[G.V()];
        girth = Integer.MAX_VALUE;

        allEccentricity(G);
        computeGirth(G);
    }

    private void computeGirth(Graph G){
        for (int v = 0; v < G.V(); v++){
            girth = Math.min(girth, bfsForGirth(G, v));
        }
    }

    private int bfsForGirth(Graph G, int s){
        Arrays.fill(marked, false);
        Arrays.fill(distTo, 0);
        Arrays.fill(edgeTo, 0);

        int shortestCycle = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w : G.adj(v)){
                if (!marked[w]){
                    queue.offer(w);
                    marked[w] = true;
                    distTo[w] = distTo[v]+1;
                    edgeTo[w] = v;
                }else if (w != edgeTo[v]){
                    // 当前w被标记过了, 并且有其它最短路径到这个w,
                    // 因此到达这个w有两条路径, 一条从v, 另一条edgeTo[v],
                    // 因此为一个环.
                    // 这个环的长度为: distTo[v]+distTo[w]+(v和w之间的边).
                    // Cycle found
                    shortestCycle = Math.min(
                            shortestCycle,
                            distTo[v]+distTo[w]+1
                    );
                }
            }
        }

        return shortestCycle;
    }

    /**
     * @return 图中最短环的长度
     */
    public int girth(){return girth;}

    /**
     * 找到所有顶点的离心率
     * @param G 一副图
     */
    private void allEccentricity(Graph G){
        for (int v = 0; v < G.V(); v++){
            e[v] = bfsForEccentricity(G, v);
        }
    }

    /**
     * 离心率，找到顶点v和其他顶点间最短路径里面最大的
     * @param G 一副图
     * @param v 一个顶点
     * @return 一个顶点的离心率
     */
    private int bfsForEccentricity(Graph G, int v){
        Arrays.fill(distTo, 0);
        Arrays.fill(marked, false); // 忘记把marked重置了!

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
        // 0-1-2-3-4-5-6-7-8-9-10
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
        System.out.println(graph);

        GraphProperties graphProperties = new GraphProperties(graph);
        StdOut.println("Diameter: " + graphProperties.diameter() + " Expected: 10");
        StdOut.println("Radius: " + graphProperties.radius() + " Expected: 5");
        StdOut.println("Center: " + graphProperties.center() + " Expected: 5");


        // ---------girth-----------
//        graph.addEdge(10, 0);
//        graph.addEdge(0,3);
//        System.out.println(graph);
//        GraphProperties在构造的时候就计算了，所以尽管加了边，
//        但并没有重新计算，输出的仍然是最开始的图（0-...-10）的girth
//        System.out.println(graphProperties.girth());

        // Graph with girth = 3
        Graph graph1 = new Graph(6);
        graph1.addEdge(2 ,3);
        graph1.addEdge(0 ,1);
        graph1.addEdge(3 ,1);
        graph1.addEdge(5 ,3);
        graph1.addEdge(2 ,0);
        graph1.addEdge(1 ,2);
        graph1.addEdge(4 ,2);
        graph1.addEdge(4 ,5);
        graph1.addEdge(4 ,0);

        // Graph with girth = 2
        Graph graph2 = new Graph(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 0); //Parallel edge
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);

        // Graph with girth = 4
        Graph graph3 = new Graph(4);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 0);

        // Graph with girth = Integer.MAX_VALUE
        Graph graph4 = new Graph(4);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 3);
        graph4.addEdge(2, 3);

        GraphProperties graphProperties1 = new GraphProperties(graph1);
        StdOut.println("Girth 1: " + graphProperties1.girth() + " Expected: 3");

        GraphProperties graphProperties2 = new GraphProperties(graph2);
        StdOut.println("Girth 2: " + graphProperties2.girth() + " Expected: 2");

        GraphProperties graphProperties3 = new GraphProperties(graph3);
        StdOut.println("Girth 3: " + graphProperties3.girth() + " Expected: 4");

        GraphProperties graphProperties4 = new GraphProperties(graph4);
        StdOut.println("Girth 4: " + graphProperties4.girth() + " Expected: 2147483647");
    }
}

