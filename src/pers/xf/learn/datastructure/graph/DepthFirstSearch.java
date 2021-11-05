package pers.xf.learn.datastructure.graph;

import edu.princeton.cs.algs4.In;

public class DepthFirstSearch implements Search{
    private final boolean[] mark;     // 记录其它节点与起点 s 的连通性
    private int count;          // 记录 s 所在的连通分量的节点个数

    /**
     * 根据输入构造图并遍历得到起点 s 与其他节点的连通性的解。
     * @param g 临接表数组图
     * @param s 起点顶点
     */
    public DepthFirstSearch(Graph g, int s){
        this.mark = new boolean[g.V()];
        this.count = 0;
        dfs(g, s);
    }

    /**
     * 深度优先搜索递归实现。
     * @param g 图
     * @param v 顶点
     */
    private void dfs(Graph g, int v){
        this.mark[v] = true;
        count ++;
        for(int w : g.adj(v)){
            if(!mark[w])    dfs(g, w);
        }
    }

    /**
     * 检查 s 和 v 是否连通。
     * @param v 一个节点
     * @return 是否连通
     */
    @Override
    public boolean marked(int v){
        return mark[v];
    }

    /**
     * @return 当前连通分量有几个顶点
     * （如果当前连通分量的顶点不等于图的所有顶点，那么不是一个连通图）
     */
    @Override
    public int count(){return this.count;}

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);

        Search search = new DepthFirstSearch(G, s);

        // 各节点与 s 是否连通
        for (int i = 0; i < G.V(); i++){
            if(search.marked(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 整个图是否是一个连通分量
        if (search.count() != G.V()) System.out.print("NOT ");
        System.out.println("connected");
    }
}
