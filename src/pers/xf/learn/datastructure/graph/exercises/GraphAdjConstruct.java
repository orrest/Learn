package pers.xf.learn.datastructure.graph.exercises;

import pers.xf.learn.datastructure.graph.Graph;
import edu.princeton.cs.algs4.In;

import java.io.FileNotFoundException;


public class GraphAdjConstruct extends Graph {
    /**
     * 从一个输入流读入一个邻接表，并构造一个邻接表（用于表示图）。
     * @param in 输入流
     */
    public GraphAdjConstruct(In in){
        super(in.readInt());
        int e = in.readInt();   // not used
        in.readLine();  // move to next line

        while (in.hasNextLine()) {
            String[] s = in.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            for (int i = 1; i < s.length; i++){
                int w = Integer.parseInt(s[i]);
                super.addEdge(v, w);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        GraphAdjConstruct G = new GraphAdjConstruct(new In(args[0]));
        System.out.println(G);
    }
}
