package pers.xf.learn.datastructure.graph;

public interface Paths {
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}
