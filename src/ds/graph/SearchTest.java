package ds.graph;

import edu.princeton.cs.algs4.In;

public class SearchTest {
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
