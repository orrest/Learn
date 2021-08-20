package ds.graph;

public interface Search {
    /**
     * 起点s与指定点v是否连通
     * @param v 指定点v
     * @return 是否连通
     */
    boolean marked(int v);

    /**
     * @return 连通分量的数量
     */
    int count();
}
