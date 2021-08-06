package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths implements Paths{
    private final boolean[] marked;
    private final int[] path;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        path = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;
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
