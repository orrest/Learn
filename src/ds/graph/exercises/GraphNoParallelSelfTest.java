package ds.graph.exercises;

import ds.graph.Graph;

/**
 * [Test]
 * 测试Graph是否实现了不能够添加平行边和自环。
 */
public class GraphNoParallelSelfTest {
    public static void main(String[] args) {
        Graph G = new Graph(3);
        try{
            G.addEdge(1, 0);
            G.addEdge(0, 1);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
