package ds.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 找出一副图所有的连通分量的数量。
 */
public class ConnectedComponents{
    /**
     * DFS 标记
     */
    private boolean[] marked;
    /**
     * 标记顶点属于哪个连通分量
     */
    private int[] id;
    /**
     * 连通分量的数量
     */
    private int count;

    /**
     * 使用 marked[] 来寻找一个顶点作为每个连通分量DFS的起点。
     *
     * 第一次是0, 然后DFS，标记与0连通的顶点，再次循环时跳过已经标记过的（已经与0连通了的），
     * 从下一个不为0的顶点开始DFS。
     *
     * 每一次DFS，count++，代表这一次连通分量的遍历。
     * @param G
     */
    public ConnectedComponents(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int s = 0; s < G.V(); s++){
            if (!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    /**
     * 时间： O(V+E)
     * 空间： O(V+E)
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if(!marked[w])  dfs(G, w);
        }
    }

    /**
     * v 和 w 连通吗？
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * 连通分量数
     * @return
     */
    int count(){
        return count;
    }

    /**
     * v 所在的连通分量id
     * @param v
     * @return
     */
    int id(int v){
        return id[v];
    }

    /**
     * 计算连通分量的个数
     * @param args
     */
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        ConnectedComponents cc = new ConnectedComponents(G);

        int M = cc.count();
        System.out.println(M + " components");

        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) components[i] = new Bag<>();
        for (int v = 0; v < G.V(); v++) components[cc.id(v)].add(v);

        for (int i = 0; i < M; i++){
            for (int v : components[i])
                System.out.print(v + " ");
            System.out.println();
        }
    }
}
