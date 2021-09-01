package ds.graph;

import edu.princeton.cs.algs4.In;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        // 遍历森林
        for (int s = 0; s < G.V(); s++){
            if (!marked[s]) dfs(G, s, s);
        }
    }

    /**
     * 从一个点开始，BFS.
     * 1. 标记当前节点
     * 2. 递归地去标记未被标记过的邻居节点
     * 3. 判断递归结束后是否返回根节点
     *
     * 一路DFS, 最终遇到两种情况:
     *  1. 叶子节点, 子树为空, 递归返回
     *  2. 非叶子节点, 邻居都被标记过, 此时有环
     *
     * 如果 u==w 则说明返回的路和来时的路是一样的, 只有一条路
     * 如果 u!=w 则说明除了自己来时的路, 还有其它的路能到自己
     * 而遍历是从 "一个" 点开始的, 对于无向图, 一个起点, 一个终点,
     * 且假设图无自环和平行边, 因此图是有环的.
     *
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
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        System.out.println(cycle.hasCycle());
    }
}
