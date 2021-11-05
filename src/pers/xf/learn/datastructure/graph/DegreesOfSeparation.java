package pers.xf.learn.datastructure.graph;

import edu.princeton.cs.algs4.StdIn;

public class DegreesOfSeparation {
    /**
     * 在符号图中找到最短路径.
     * @param args
     *              args[0] : filename
     *              args[1] : delimiter
     *              args[2] : start symbol
     */
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()){ // 输入要查找的最短路径终点symbol.
            String sink = StdIn.readLine();
            if (sg.contains(sink)){
                int  t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v : bfs.pathTo(t)) // 打印通过BFS获得的路径.
                        System.out.println("   " + sg.name(v));
                else System.out.println("Not connected");
            }
            else System.out.println("Not in database");
        }
    }
}
