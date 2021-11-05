package pers.xf.learn.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到两点之间的最短路径
 */
public class BreadthFirstPaths implements Paths{
    /**
     * 因为是无向图，子节点的邻居也是父节点，所以需要标记一下;
     * 同时，marked数组可以判断顶点是否与起点连通（是否从起点开始到达过）。
     */
    private final boolean[] marked;
    private final int[] path;
    private final int s;

    /**
     * 得到各顶点到起点的最短路径
     * @param G 一副无向图
     * @param s 起点
     */
    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        path = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * 通过BFS得到各顶点到起点的最短路径
     * @param G 一副无向图
     * @param s 起点
     */
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;   // 因为是无向图，子节点的邻居也是父节点，所以需要标记一下。
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    path[w] = v;
                    queue.offer(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!this.hasPathTo(v))  return new LinkedList<>();

        LinkedList<Integer> stack = new LinkedList<>();
        for (int w = v; w != s; w = path[w]){
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
