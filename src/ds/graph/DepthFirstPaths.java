package ds.graph;

import java.util.LinkedList;

public class DepthFirstPaths implements Paths{

    /**
     * 第一次来到一个节点，标记为已经到过。
     */
    private final boolean[] marked;
    /**
     * 记录来向。
     * 为什么不记录去向？
     * - 因为去了之后还要折回，那么第一次的去向就被覆盖了。
     */
    private final int[] path;
    private final int s;

    /**
     * 初始化标记数组、路径数组、起始节点。
     * 并遍历整个图，完成标记数组和路径数组的填充。
     * @param G 临接表矩阵表示的无向图
     * @param s 起点
     */
    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        path = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * 遍历图，获取所需信息。
     * @param G 临接表矩阵表示的无向图
     * @param v 一个节点
     */
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                path[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 起点s是否有到达终点v的路径
     * @param v 终点
     * @return true or false
     */
    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 起点s到达终点v的路径
     * @param v 终点
     * @return 可迭代对象
     */
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
