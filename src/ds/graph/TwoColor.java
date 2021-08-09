package ds.graph;

import edu.princeton.cs.algs4.In;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        isTwoColorable = true;
        for (int s = 0; s < G.V(); s++){
            if (!marked[s]) dfs(G, s);
        }
    }

    /**
     * 遍历去的时候, 邻居节点和父节点标记为不同的颜色
     *   color[w] = !color[v];
     *
     * 当递归返回的时候, 来时的w变成了v,
     * 此时, v的邻居包含了一条来时的路, 这个边的两端节点颜色一定不相同,
     * 但是, 当前v可能与来时的父节点的邻居节点有边, v与这个节点的颜色相同.
     *
     * @param G 无向图
     * @param v 起点
     */
    public void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                color[w] = !color[v];
                dfs(G, w);
            }else if (color[w] == color[v]) isTwoColorable = false;

        }
    }

    public boolean isBipartite(){return isTwoColorable;}

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(new TwoColor(G).isBipartite());
    }
}
