package ds.graph;

public class DepthFirstSearch implements Search{
    private boolean[] mark;     // 记录其它节点与起点 s 的连通性
    private int count;          // 记录 s 所在的连通分量的节点个数

    /**
     * 根据输入构造图并遍历得到起点 s 与其他节点的连通性的解。
     * @param g
     * @param s
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
     * @return
     */
    @Override
    public boolean marked(int v){
        return mark[v];
    }

    @Override
    public int count(){return this.count;}
}
