package pers.xf.learn.designpattern.proxy.dynamicproxy;

import pers.xf.learn.designpattern.proxy.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用动态代理实现之后，不仅能实现Order类的数据源动态路由，还可以实现其他任何类的数据源路由。
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        before(args[0]);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(Object target){
        try {
            Long time = (Long) target
                    .getClass()
                    .getMethod("getCreateTime")
                    .invoke(target);

            int dbRouter = Integer.parseInt(yearFormat.format(new Date(time)));
            System.out.println("静态代理分配到【DB_"+dbRouter+"】数据源处理数据");

            DynamicDataSourceEntry.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("----Proxy before method.----");
        }
    }

    private void after(){
        System.out.println("----Proxy after method.----");
    }
}
