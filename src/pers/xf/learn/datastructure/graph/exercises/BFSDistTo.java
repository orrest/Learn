package pers.xf.learn.datastructure.graph.exercises;

import pers.xf.learn.datastructure.graph.Graph;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到每个顶点到起点s的最短路径
 */
public class BFSDistTo {
    private final boolean[] marked;
    private final int[] distTo;

    public BFSDistTo(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[s] = 0;

        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w : G.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    distTo[w] = distTo(v)+1;
                    queue.offer(w);
                }
            }
        }
    }

    public int distTo(int v)    { return distTo[v]; }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = 0;
        BFSDistTo dist = new BFSDistTo(G, s);
        for (int v = 0; v < G.V(); v++){
            System.out.println(v+" -> "+s+" "+dist.distTo(v));
        }
    }
}
