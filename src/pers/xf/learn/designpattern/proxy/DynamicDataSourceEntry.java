package pers.xf.learn.designpattern.proxy;

/**
 * 动态切换数据源
 * 根据订单创建时间自动按年进行分库
 */
public class DynamicDataSourceEntry {
    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry(){}

    /**
     * 清空数据源
     */
    public static void clear(){
        local.remove();
    }

    /**
     * 获取当前数据源的名字
     * @return 当前数据源名字
     */
    public static String get(){
        return local.get();
    }

    /**
     * 恢复默认数据源
     */
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    /**
     * 根据年份设置数据源
     * @param year 年份
     */
    public static void set(int year){
        local.set("DB_"+year);
    }
}
