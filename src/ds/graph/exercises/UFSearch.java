package ds.graph.exercises;

import ds.graph.Graph;
import ds.graph.Search;
import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

public class UFSearch implements Search {
    private final int[] father;
    private final int[] rank;
    private int count;

    private final int s;

    public UFSearch(Graph G, int s){
        this.s = s;

        count = G.V();
        father = new int[G.V()];
        rank = new int[G.V()];

        for (int i = 0; i < father.length; i++){
            father[i] = i;
            rank[i] = 0;
        }

        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                this.union(v, w);
    }

    /**
     * 将一个顶点所在的集合并入另外一个顶点所在的集合
     * @param p 顶点
     * @param q 顶点
     */
    private void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (rank[rootP] < rank[rootQ])      {father[rootP] = rootQ;}
        else if (rank[rootP] > rank[rootQ]) {father[rootQ] = rootP;}
        else                                {father[rootP] = rootQ; rank[rootQ] += 1;}

        count--;
    }

    /**
     * @param p 顶点p
     * @return p父顶点
     */
    private int find(int p){
        LinkedList<Integer> stack = new LinkedList<>();
        int f = father[p];
        while (p != f){
            stack.push(p);
            p = f;
            f = father[f];
        }
        while (!stack.isEmpty()){
            father[stack.pop()] = f;
        }
        return f;
    }

    /**
     * @param v 指定点v
     * @return v和s是否连通
     */
    @Override
    public boolean marked(int v) {
        return find(s) == find(v);
    }

    /**
     * @return 连通分量数量
     */
    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);

        UFSearch ufSearch = new UFSearch(G, 9);

        System.out.println("Connected components: "+ufSearch.count());
        for (int v = 0; v < G.V(); v++){
            System.out.println(ufSearch.s + " connected " + v + " " + ufSearch.marked(v));
        }
    }
}
