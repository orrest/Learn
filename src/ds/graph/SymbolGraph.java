package ds.graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolGraph {
    private final ST<String, Integer> st;
    private final String[] keys;
    private final Graph G;

    public SymbolGraph(String filename, String delim){
        st = new ST<>();                     // 一个Map

        // 第一遍遍历， 构建索引
        In in = new In(filename);                           // 读取文件
        while (in.hasNextLine()){
            String[] a = in.readLine().split(delim);
            for (String s : a) {
                if (!st.contains(s))
                    st.put(s, st.size());                   // 建立 name -> index 符号表
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys())
            keys[st.get(name)] = name;                      // 建立 index -> name 反向索引

        // 第二遍遍历， 构造图
        G = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()){
            String[] a = in.readLine().split(delim);
            int v = st.get(a[0]);                           // 每行第一个字符串，如，电影名
            for (int i = 1; i < a.length; i++)              // 每行剩下的字符串，如，演员
                G.addEdge(v, st.get(a[i]));                 // 使用索引构造如 电影名 -> 演员 的边
        }
    }

    /**
     * 符号表是否包含节点
     * @param key 字符名
     * @return 是否包含
     */
    public boolean contains(String key) { return st.contains(key); }

    /**
     * 将索引名转化为索引，以便在图处理算法中使用。
     * @param key 字符名
     * @return 字符名对应的索引
     */
    public int index(String key)    { return st.get(key); }

    /**
     * 将索引转化为原名，以便在实际应用中使用。
     * @param v 索引
     * @return 索引对应的字符名
     */
    public String name(int v)   { return keys[v]; }

    Graph G()   { return G; }

    /**
     * 二分图的性质自动完成了反向索引。
     * 输入演员的名字来得到电影名称。
     * @param args args[0] 文件名, args[1] 分隔符
     */
    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);

        Graph G = sg.G();

        while (StdIn.hasNextLine()){
            String source = StdIn.readLine(); // 反向查找, 如, 演员的名字
            // 因为是无向图, 按电影->演员构造的边.
            // 所以演员也连接着电影, 直接查找就好.
            for (int w : G.adj(sg.index(source)))
                StdOut.println("   " + sg.name(w));
        }
    }
}
