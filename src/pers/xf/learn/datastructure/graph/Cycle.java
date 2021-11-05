package pers.xf.learn.datastructure.graph;

import edu.princeton.cs.algs4.In;

public class Cycle {
    private final boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        // 遍历森林
        for (int s = 0; s < G.V(); s++){
            if (!marked[s]) dfs(G, s, s);
        }
    }

    /**
     * 从一个点开始，DFS.
     * 1. 标记当前节点
     * 2. 递归地去标记未被标记过的邻居节点
     * 3. 递归结束后判断是否有除来向之外的路径
     *
     * 如果 u==w 则说明返回的路和来时的路是一样的, 只有一条路
     * 如果 u!=w 则说明除了自己来时的路, 还有其它的路能到自己
     * 而遍历是从 "一个" 点开始的, 对于无向图, 一个起点, 一个终点,
     * 且假设图无自环和平行边, 因此图是有环的.
     *
     * 没有环的情况下
     * else if (w!=u) 只会在来向的时候触发:
     *  1-2
     *  dfs(1): 1->2
     *      v=1, w=2, u=1, dfs(2)
     *  dfs(2): 1<-2
     *      v=2, w=1, u=1, return
     *      w==u, u为v的来向, w为连着v的顶点
     * @param G 无向图
     * @param v 开始节点
     * @param u 根节点
     */
    private void dfs(Graph G, int v, int u){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]) dfs(G, w, v);
            else if (w != u) hasCycle = true;
        }
    }

    public boolean hasCycle(){return hasCycle;}

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,3);
        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle());
        // --------------------------------
        Graph G1 = new Graph(new In(args[0]));
        Cycle cycle1 = new Cycle(G1);
        System.out.println(cycle1.hasCycle());
    }
}
